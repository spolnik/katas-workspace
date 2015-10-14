package org.craftedsw.harddependencies.trip;

import org.craftedsw.harddependencies.user.User;

import java.util.List;

public class TripDAOWrapper implements TripRepository {

    @Override
    public List<Trip> findTripsByUser(User user) {
        return TripDAO.findTripsByUser(user);
    }
}
