package com.javastream.configs;

/**
 * Settings.
 *
 * @author javastream
 */
public class Settings {
    public static String token;
    public static String account;
    public static Integer restID;

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

    public static Integer getRestID() {
        return restID;
    }

    public static void setRestID(Integer restID) {
        Settings.restID = restID;
    }
}
