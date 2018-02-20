package com.wrathspectre.computercontrol;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class DesktopControlsFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.desktop_controls_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomNavigationView navigationView = view.findViewById(R.id.desktop_controls_navigation);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch(item.getItemId()) {
                    case R.id.general:
                        fragmentTransaction.replace(R.id.desktop_controls_fragment_area, new GeneralFragment()).commit();
                        return true;

                    case R.id.media:
                        //fragmentTransaction.replace(R.id.desktop_controls_fragment_area, new GeneralFragment()).commit();
                        return true;

                    case R.id.presentation:
                        //fragmentTransaction.replace(R.id.desktop_controls_fragment_area, new GeneralFragment()).commit();
                        return true;

                    case R.id.browser:
                        //fragmentTransaction.replace(R.id.desktop_controls_fragment_area, new GeneralFragment()).commit();
                        return true;

                    case R.id.shortcut:
                        //fragmentTransaction.replace(R.id.desktop_controls_fragment_area, new GeneralFragment()).commit();
                        return true;
                }
                return false;
            }
    };
}
