package com.venuesapp.nearbyvenues.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.venuesapp.nearbyvenues.R;
import com.venuesapp.nearbyvenues.model.local.VenueRealm;
import com.venuesapp.nearbyvenues.model.local.VenuesResponseRealm;
import com.venuesapp.nearbyvenues.presenter.VenuesListContract;
import com.venuesapp.nearbyvenues.presenter.VenuesListPresenter;

import java.util.ArrayList;

public class VenuesListActivity extends AppCompatActivity implements VenuesListContract.View {

    private static final String MESSAGE_NO_DATA = "MESSAGE_NO_DATA";

    private VenuesListContract.Actions presenter;

    private RecyclerView recyclerView;

    private RecyclerViewAdapter adapter;

    private ArrayList<VenueRealm> VenueRealmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        presenter = new VenuesListPresenter(this);

    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showVenues(VenuesResponseRealm venuesResponseRealm) {

        for (VenueRealm venue : venuesResponseRealm.getVenues()) {
            if (venue.getAddress() == null) venue.setAddress(getStringResourceByName(MESSAGE_NO_DATA));
            if (venue.getFormattedPhone() == null) venue.setFormattedPhone(getStringResourceByName(MESSAGE_NO_DATA));
        }

        VenueRealmList = new ArrayList<>(venuesResponseRealm.getVenues());
        adapter = new RecyclerViewAdapter(VenueRealmList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(String messageGetVenuesDataError) {
        Toast.makeText(this, getStringResourceByName(messageGetVenuesDataError), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showComplete(String messageGetVenuesDataComplete) {
        Toast.makeText(this, getStringResourceByName(messageGetVenuesDataComplete), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    /*
    * Получаем содержание строки по имени string ресурса (в xml файлах)
    */

    private String getStringResourceByName(String str) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(str, "string", packageName);
        return getString(resId);
    }
}
