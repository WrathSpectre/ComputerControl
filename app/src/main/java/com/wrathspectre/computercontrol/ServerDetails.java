package com.wrathspectre.computercontrol;

public class ServerDetails {
    private int logo;
    private String name;
    private String ip;
    private int port;
    private String available;

    public ServerDetails(final int logo, final String name, final String ip, final int port, final String available) {
        this.logo = logo;
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.available = available;
    }

    public int getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getIP() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getAvailable() {
        return available;
    }
}
