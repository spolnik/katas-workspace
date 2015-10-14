package org.craftedsw.harddependencies.trip;

import org.craftedsw.harddependencies.user.User;

import java.util.List;

public interface TripRepository {
    List<Trip> findTripsByUser(User user);
}
