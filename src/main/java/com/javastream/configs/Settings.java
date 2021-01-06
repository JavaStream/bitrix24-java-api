package com.javastream.configs;


public class Settings {
    public static String token;
    public static String account;
    public static Integer rest_ID;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Settings.token = token;
    }

    public static String getAccount() {
        return account;
    }

    public static void setAccount(String account) {
        Settings.account = account;
    }

    public static Integer getRest_ID() {
        return rest_ID;
    }

    public static void setRest_ID(Integer rest_ID) {
        Settings.rest_ID = rest_ID;
    }
}
