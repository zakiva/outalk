package com.example.zakiva.outalk;

/**
 * Created by Ariel on 5/23/2016.
 */

import java.util.List;

public class GroupInfo {
    List users;
    String name;
    int numOfUsers;

    // Required default constructor for Firebase object mapping
    GroupInfo(){
    }

    GroupInfo(String name, int numOfUsers, List users) {
        this.name = name;
        this.numOfUsers = numOfUsers;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public List getUsers() {
        return users;
    }

    public int getNumOfUsers() {
        return numOfUsers;
    }
}
