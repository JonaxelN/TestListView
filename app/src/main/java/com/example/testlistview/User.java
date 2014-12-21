package com.example.testlistview;

import java.util.ArrayList;

/**
 * Created by jonathan on 21/12/14.
 */
public class User {

    public String name;
    public String hometown;

    public User(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Harry", "San Diego"));
        users.add(new User("Marla", "San Francisco"));
        users.add(new User("Sarah", "San Marco"));
        return users;
    }
}
