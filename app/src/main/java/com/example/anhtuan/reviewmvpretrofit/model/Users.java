package com.example.anhtuan.reviewmvpretrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ANH TUAN on 2/1/2018.
 */

public class Users {

    @SerializedName("login")
    private String login;
    @SerializedName("id")
    private int id;
    @SerializedName("avatar_url")
    private String avatar_url;

    public Users() {
    }

    public Users(String login, int id, String avatar_url) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }
}
