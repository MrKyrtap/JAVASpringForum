package com.grudnik.dto;

import com.grudnik.entities.User;

import java.util.List;

/**
 * Created by PatrykGrudnik on 29/07/2017.
 */
public class InfoDTO {
    String lastUser;
    int usersCount;
    int topicsCount;
    int postsCount;
    List<User> usersOnline;

    public List<User> getUsersOnline() {
        return usersOnline;
    }

    public void setUsersOnline(List<User> usersOnline) {
        this.usersOnline = usersOnline;
    }

    public int getTopicsCount() {
        return topicsCount;
    }

    public void setTopicsCount(int topicsCount) {
        this.topicsCount = topicsCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }
}
