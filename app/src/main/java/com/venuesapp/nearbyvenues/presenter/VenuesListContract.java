package com.venuesapp.nearbyvenues.presenter;

import com.venuesapp.nearbyvenues.model.local.VenuesResponseRealm;

public class VenuesListContract {

    public interface View {

        void showVenues(VenuesResponseRealm venuesResponseRealm);

        void showError(String messageGetVenuesDataError);

        void showComplete(String messageGetVenuesDataComplete);
    }

    public interface Actions {

        void loadVenuesData();

        void loadVenuesDataFromRemoteDataBase();

        void subscribe();

        void unsubscribe();

    }


}
