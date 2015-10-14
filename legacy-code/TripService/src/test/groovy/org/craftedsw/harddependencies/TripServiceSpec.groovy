package org.craftedsw.harddependencies

import org.craftedsw.harddependencies.exception.UserNotLoggedInException
import org.craftedsw.harddependencies.trip.Trip
import org.craftedsw.harddependencies.trip.TripRepository
import org.craftedsw.harddependencies.user.User
import org.craftedsw.harddependencies.user.UserSession
import spock.lang.Specification

class TripServiceSpec extends Specification {

    TripService tripService

    UserSession userSession
    TripRepository tripRepository

    List<Trip> trips

    Trip friendTrip
    User friend

    def setup() {
        userSession = Mock(UserSession)
        tripRepository = Mock(TripRepository)

        tripService = new TripService(userSession, tripRepository)
    }

    def "throws UserNotLoggedInException if there is no user logged in"() {
        setup:

        userSession.getLoggedUser() >> null

        when:
        tripService.getTripsByUser(new User())

        then:
        def e = thrown(UserNotLoggedInException)
        e.cause == null
    }

    def "returns empty trip list for user who is not a friend"() {
        setup:
        def loggedUser = new User()
        userSession.getLoggedUser() >> loggedUser

        when:
        trips = tripService.getTripsByUser(new User())

        then:
        trips.empty
    }

    def "returns list of friend trips for user who is a friend"() {
        setup:
        def loggedUser = new User()
        userSession.getLoggedUser() >> loggedUser

        friend = new User()
        friend.addFriend(loggedUser)
        friend.addTrip(friendTrip)

        tripRepository.findTripsByUser(friend) >> [friendTrip]

        when:
        trips = tripService.getTripsByUser(friend)

        then:
        !trips.empty
        trips.first() == friendTrip
    }
}
