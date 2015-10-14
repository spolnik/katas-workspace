package org.craftedsw.harddependencies

import org.craftedsw.harddependencies.exception.UserNotLoggedInException
import org.craftedsw.harddependencies.trip.Trip
import org.craftedsw.harddependencies.trip.TripRepository
import org.craftedsw.harddependencies.user.User
import org.craftedsw.harddependencies.user.UserSession
import spock.lang.Specification

import static org.craftedsw.harddependencies.UserBuilder.aUser

class TripServiceSpec extends Specification {

    User GUEST = null
    User REGISTERED_USER = new User()
    User A_USER = new User()
    User ANOTHER_USER = new User()

    Trip KRAKOW = new Trip()
    Trip LONDON = new Trip()

    TripService tripService
    UserSession userSession
    TripRepository tripRepository

    def setup() {
        userSession = Mock(UserSession)
        tripRepository = Mock(TripRepository)

        tripService = new TripService(userSession, tripRepository)
    }

    def "validates that user is logged in"() {
        setup:
        userSession.getLoggedUser() >> GUEST

        when:
        tripService.getTripsByUser(A_USER)

        then:
        thrown(UserNotLoggedInException)
    }

    def "returns no trips when users are not friends"() {
        setup:
        userSession.getLoggedUser() >> REGISTERED_USER

        def stranger = aUser()
            .withFriends(ANOTHER_USER)
            .withTrips(KRAKOW)
            .build()

        when:
        def trips = tripService.getTripsByUser(stranger)

        then:
        trips.empty
    }

    def "returns friend trips for users who are friends"() {
        setup:
        userSession.getLoggedUser() >> REGISTERED_USER

        def friend = aUser()
            .withFriends(REGISTERED_USER, ANOTHER_USER)
            .withTrips(KRAKOW, LONDON)
            .build()

        tripRepository.findTripsByUser(friend) >> friend.trips()

        when:
        def trips = tripService.getTripsByUser(friend)

        then:
        trips.first() == KRAKOW
    }
}
