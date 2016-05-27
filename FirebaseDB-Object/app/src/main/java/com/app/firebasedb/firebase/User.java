package com.app.firebasedb.firebase;

/**
 * Created by zeeshanhanif-pc on 5/27/2016.
 */
public class User {

    private String name;
    private int age;
    private String username;

    public User(){

    }
    public User(String name, String username, int age) {
        this.name = name;
        this.username = username;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
