package com.grudnik.dto;

import com.grudnik.entities.Post;
import com.grudnik.entities.User;

/**
 * Created by PatrykGrudnik on 30/07/2017.
 */
public class ProfileDTO {
    User user;
    int postsCount;
    int topicCount;
    Post lastPost;
    int userAge;

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public int getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(int topicCount) {
        this.topicCount = topicCount;
    }

    public Post getLastPost() {
        return lastPost;
    }

    public void setLastPost(Post lastPost) {
        this.lastPost = lastPost;
    }
}
