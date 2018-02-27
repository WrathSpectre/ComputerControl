package com.wrathspectre.computercontrol;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ConnectionActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ServerAdapter adapter;

    List<ServerDetails> serverList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_activity);

        getSupportActionBar().setTitle("Connection management");
        getSupportActionBar().setElevation(0);

        serverList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ServerAdapter(this, serverList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.add_server_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ConnectionActivity.this);
                final View dialogView = getLayoutInflater().inflate(R.layout.server_dialog, null);

                final RadioGroup systemPicker = dialogView.findViewById(R.id.system_options);
                final EditText serverName = dialogView.findViewById(R.id.server_name);
                final EditText serverIP = dialogView.findViewById(R.id.server_ip);
                final EditText serverPort = dialogView.findViewById(R.id.server_port);
                Button addServer = dialogView.findViewById(R.id.server_add);

                dialogBuilder.setView(dialogView);
                final AlertDialog dialog = dialogBuilder.create();

                addServer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("D", serverName.getText().toString());
                        serverList.add(new ServerDetails(123, serverName.getText().toString(), serverIP.getText().toString(), Integer.valueOf(serverPort.getText().toString()), "Available"));
                        ServerAdapter nadapter = new ServerAdapter(getBaseContext(), serverList);
                        recyclerView.setAdapter(nadapter);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
}
