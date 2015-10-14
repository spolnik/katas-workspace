package org.craftedsw.harddependencies

import org.craftedsw.harddependencies.trip.Trip
import org.craftedsw.harddependencies.user.User

class UserBuilder {
    private def user = new User()

    def withFriends(User... users) {
        users.each { friend ->
            user.addFriend(friend)
        }
        this
    }

    def withTrips(Trip... trips) {
        trips.each { trip ->
            user.addTrip(trip)
        }
        this
    }

    def build() {
        return user
    }

    static UserBuilder aUser() {
        return new UserBuilder()
    }
}