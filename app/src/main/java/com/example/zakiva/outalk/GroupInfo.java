package com.example.zakiva.outalk;

/**
 * Created by Ariel on 5/23/2016.
 */
public class GroupInfo {
    String name;
    String numOfUsers;

    // Required default constructor for Firebase object mapping
    GroupInfo(){
    }

    GroupInfo(String name, String numOfUsers) {
        this.name = name;
        this.numOfUsers = numOfUsers;
    }

    public String getName() {
        return name;
    }

    public String getNumOfUsers() {
        return numOfUsers;
    }
}
