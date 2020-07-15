package com.malingi.orbicoin;

public class Conversation {

    int avatar;
    String username, message;

    public Conversation (int avatar, String username, String message) {

        this.avatar = avatar;
        this.username = username;
        this.message = message;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getName() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}
