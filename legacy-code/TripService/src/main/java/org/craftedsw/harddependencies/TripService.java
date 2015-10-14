package org.craftedsw.harddependencies;

import org.craftedsw.harddependencies.exception.UserNotLoggedInException;
import org.craftedsw.harddependencies.trip.Trip;
import org.craftedsw.harddependencies.trip.TripDAOWrapper;
import org.craftedsw.harddependencies.trip.TripRepository;
import org.craftedsw.harddependencies.user.User;
import org.craftedsw.harddependencies.user.UserSession;

import java.util.Collections;
import java.util.List;

public class TripService {

    private final UserSession userSession;
    private final TripRepository tripRepository;

    public TripService() {
        this(UserSession.getInstance(), new TripDAOWrapper());
    }

    public TripService(UserSession userSession, TripRepository tripRepository) {
        this.userSession = userSession;
        this.tripRepository = tripRepository;
    }

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {

        User loggedUser = checkAndReturnUserIfUserIsLoggedIn(
                userSession.getLoggedUser()
        );

        return getUserTripsIfLoggedUserIsAFriend(user, loggedUser);
    }

    private User checkAndReturnUserIfUserIsLoggedIn(User loggedUser) throws UserNotLoggedInException {

        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }

        return loggedUser;
    }

    private List<Trip> getUserTripsIfLoggedUserIsAFriend(User user, User loggedUser) {

        return user.isFriendsWith(loggedUser)
                ? tripRepository.findTripsByUser(user)
                : Collections.emptyList();
    }
}
