package org.craftedsw.harddependencies

import org.craftedsw.harddependencies.exception.UserNotLoggedInException
import org.craftedsw.harddependencies.trip.Trip
import org.craftedsw.harddependencies.trip.TripRepository
import org.craftedsw.harddependencies.user.User
import org.craftedsw.harddependencies.user.UserSession
import spock.lang.Specification

class TripServiceSpec extends Specification {

    User GUEST = null
    User LOGGED_IN_USER = new User()
    User A_USER = new User()

    List<Trip> FRIEND_TRIPS
    Trip FRIEND_TRIP = new Trip()

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

    def "returns empty trip list for user who is not a friend"() {
        setup:
        userSession.getLoggedUser() >> LOGGED_IN_USER

        when:
        FRIEND_TRIPS = tripService.getTripsByUser(A_USER)

        then:
        FRIEND_TRIPS.empty
    }

    def "returns list of friend trips for user who is a friend"() {
        setup:
        userSession.getLoggedUser() >> LOGGED_IN_USER
        A_USER.addFriend(LOGGED_IN_USER)
        tripRepository.findTripsByUser(A_USER) >> [FRIEND_TRIP]

        when:
        FRIEND_TRIPS = tripService.getTripsByUser(A_USER)

        then:
        !FRIEND_TRIPS.empty
        FRIEND_TRIPS.first() == FRIEND_TRIP
    }
}
