package org.craftedsw.harddependencies

import org.craftedsw.harddependencies.exception.UserNotLoggedInException
import org.craftedsw.harddependencies.trip.Trip
import org.craftedsw.harddependencies.user.User
import org.craftedsw.harddependencies.user.UserSession
import spock.lang.Specification

class TripServiceSpec extends Specification {

    UserSession userSession
    List<Trip> trips

    def setup() {
        userSession = Mock(UserSession)
    }

    def "throws UserNotLoggedInException if there is no user logged in"() {
        setup:

        userSession.getLoggedUser() >> null

        when:
        def service = new TripService(userSession)
        service.getTripsByUser(new User())

        then:
        def e = thrown(UserNotLoggedInException)
        e.cause == null
    }

    def "returns empty trip list for user who is not a friend"() {
        setup:
        def loggedUser = new User()
        userSession.getLoggedUser() >> loggedUser

        when:
        def service = new TripService(userSession)
        trips = service.getTripsByUser(new User())

        then:
        trips.empty
    }
}
