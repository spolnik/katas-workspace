package org.craftedsw.harddependencies

import org.craftedsw.harddependencies.user.User
import spock.lang.Specification

import static org.craftedsw.harddependencies.UserBuilder.aUser

class UserSpec extends Specification {

    User MARTIN = new User()
    User BOB = new User()

    def "informs when users are not friends"() {
        when:
        def user = aUser()
            .withFriends(BOB)
            .build()

        then:
        !user.isFriendsWith(MARTIN)
    }

    def "informs when users are friends"() {
        when:
        def user = aUser()
            .withFriends(BOB, MARTIN)
            .build()

        then:
        user.isFriendsWith(MARTIN)
    }
}
