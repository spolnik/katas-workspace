package org.craftedsw.harddependencies

import org.craftedsw.harddependencies.exception.DependendClassCallDuringUnitTestException
import org.craftedsw.harddependencies.trip.TripDAO
import org.craftedsw.harddependencies.user.User
import spock.lang.Specification

class TripDAOSpec extends Specification {

    User DUMMY_USER = null

    def "throws an exception when any trips are returned"() {
        when:
        new TripDAO().tripsBy(DUMMY_USER)

        then:
        thrown(DependendClassCallDuringUnitTestException)
    }
}
