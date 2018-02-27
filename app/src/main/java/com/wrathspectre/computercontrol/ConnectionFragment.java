package com.wrathspectre.computercontrol;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ConnectionFragment extends Fragment {
    NetworkConnection net;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.connection_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomNavigationView navigationView = view.findViewById(R.id.connection_navigation);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        /*new ConnectTask().execute("");
        Button button = view.findViewById(R.id.connect);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "KIATSO");
            }
        });*/

    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch(item.getItemId()) {
                case R.id.server_list:
                    fragmentTransaction.replace(R.id.connection_fragment_area, new serverFragment()).commit();
                    break;

                case R.id.connection_settings:
                    fragmentTransaction.replace(R.id.connection_fragment_area, new ConnectionSettingsFragment()).commit();
                    break;
            }

            return false;
        }
    };

    public class ConnectTask extends AsyncTask<String, String, NetworkConnection> {
        @Override
        protected NetworkConnection doInBackground(String... message) {
            NetworkConnection.ip = "192.168.1.132";
            NetworkConnection.port = 8080;

            net = NetworkConnection.getInstance();
            net.run();
            return null;
        }
    }

    public class sendTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            net.send(params[0]);
            return null;
        }
    }

    public class DisconnectTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            net.stop();
            net = null;

            return null;
        }
    }
}
