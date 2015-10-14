package org.craftedsw.harddependencies

import org.craftedsw.harddependencies.exception.UserNotLoggedInException
import org.craftedsw.harddependencies.user.User
import org.craftedsw.harddependencies.user.UserSession
import spock.lang.Specification

class TripServiceSpec extends Specification {

    def "throws UserNotLoggedInException if there is no user logged in"() {
        setup:
        def userSession = Mock(UserSession)
        userSession.getLoggedUser() >> null

        when:
        def service = new TripService(userSession)
        service.getTripsByUser(new User())

        then:
        def e = thrown(UserNotLoggedInException)
        e.cause == null
    }
}
