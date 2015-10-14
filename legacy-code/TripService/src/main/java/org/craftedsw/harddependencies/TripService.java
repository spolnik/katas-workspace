package org.craftedsw.harddependencies;

import org.craftedsw.harddependencies.exception.UserNotLoggedInException;
import org.craftedsw.harddependencies.trip.Trip;
import org.craftedsw.harddependencies.trip.TripDAOWrapper;
import org.craftedsw.harddependencies.trip.TripRepository;
import org.craftedsw.harddependencies.user.User;
import org.craftedsw.harddependencies.user.UserSession;

import java.util.ArrayList;
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

        User loggedUser = userSession.getLoggedUser();

        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }

        return getTripsForUser(user, loggedUser);
    }

    private List<Trip> getTripsForUser(User user, User loggedUser) {

        boolean isFriend = false;
        List<Trip> tripList = new ArrayList<>();

        for (User friend : user.getFriends()) {
            if (friend.equals(loggedUser)) {
                isFriend = true;
                break;
            }
        }

        if (isFriend) {
            tripList = tripRepository.findTripsByUser(user);
        }

        return tripList;
    }
}
