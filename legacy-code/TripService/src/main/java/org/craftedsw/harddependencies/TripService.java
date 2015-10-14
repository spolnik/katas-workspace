package org.craftedsw.harddependencies;

import org.craftedsw.harddependencies.exception.UserNotLoggedInException;
import org.craftedsw.harddependencies.trip.Trip;
import org.craftedsw.harddependencies.trip.TripDAO;
import org.craftedsw.harddependencies.user.User;
import org.craftedsw.harddependencies.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    private UserSession userSession;

    public TripService() {
        this(UserSession.getInstance());
    }

    public TripService(UserSession userSession) {
        this.userSession = userSession;
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
            tripList = TripDAO.findTripsByUser(user);
        }

        return tripList;
    }
}
