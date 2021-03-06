package org.craftedsw.harddependencies;

import org.craftedsw.harddependencies.exception.UserNotLoggedInException;
import org.craftedsw.harddependencies.trip.Trip;
import org.craftedsw.harddependencies.trip.TripRepository;
import org.craftedsw.harddependencies.user.User;

import java.util.Collections;
import java.util.List;

public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getTripsByUser(User user, User loggedInUser) throws UserNotLoggedInException {

        checkIfUserIsLoggedIn(loggedInUser);

        return user.isFriendsWith(loggedInUser)
                ? tripRepository.tripsBy(user)
                : noTrips();
    }

    private void checkIfUserIsLoggedIn(User loggedUser) throws UserNotLoggedInException {

        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }
    }

    private List<Trip> noTrips() {
        return Collections.emptyList();
    }
}
