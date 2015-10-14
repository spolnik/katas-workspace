package org.craftedsw.harddependencies

import org.craftedsw.harddependencies.exception.UserNotLoggedInException
import org.craftedsw.harddependencies.trip.Trip
import org.craftedsw.harddependencies.trip.TripRepository
import org.craftedsw.harddependencies.user.User
import org.craftedsw.harddependencies.user.UserSession
import spock.lang.Specification

class TripServiceSpec extends Specification {

    User GUEST = null
    User REGISTERED_USER = new User()
    User A_USER = new User()
    User ANOTHER_USER = new User()

    Trip POLAND = new Trip()

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

        def stranger = new User()
        stranger.addFriend(ANOTHER_USER)
        stranger.addTrip(POLAND)

        when:
        def trips = tripService.getTripsByUser(stranger)

        then:
        trips.empty
    }

    def "returns friend trips for users who are friends"() {
        setup:
        userSession.getLoggedUser() >> REGISTERED_USER

        def friend = new User()
        friend.addFriend(REGISTERED_USER)
        tripRepository.findTripsByUser(friend) >> [POLAND]

        when:
        def trips = tripService.getTripsByUser(friend)

        then:
        trips.first() == POLAND
    }
}
