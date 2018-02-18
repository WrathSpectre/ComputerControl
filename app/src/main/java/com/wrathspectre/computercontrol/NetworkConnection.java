package com.wrathspectre.computercontrol;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkConnection {
    public static String ip;
    public static int port;

    private boolean connectionStatus = false;

    private Socket socket;
    private BufferedReader inReader;
    private PrintWriter outWriter;

    private String message = null;

    private static NetworkConnection instance = null;

    public static NetworkConnection getInstance() {
        if(instance == null)
            instance = new NetworkConnection();
        return instance;
    }

    NetworkConnection() {}

    public void run() {
        try {
            socket = new Socket(ip, port);
            connectionStatus = true;

            try {
                inReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                outWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                while (connectionStatus) {
                    message = inReader.readLine();

                    if(message != null) {
                        Log.d("S: ", message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(final String message) {
        if(outWriter != null && !outWriter.checkError()) {
            outWriter.println(message);
            outWriter.flush();
        }
    }

    public void stop() {
        connectionStatus = false;

        if(outWriter != null) {
            outWriter.flush();
            outWriter.close();
        }

        inReader = null;
        outWriter = null;
        socket = null;
    }
}
