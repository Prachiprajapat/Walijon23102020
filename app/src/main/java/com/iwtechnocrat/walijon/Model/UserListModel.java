package com.iwtechnocrat.walijon.Model;

public class UserListModel {
    String  id,username, usernumber, userclass;

    public UserListModel(String id, String username, String usernumber, String userclass) {
        this.id = id;
        this.username = username;
        this.usernumber = usernumber;
        this.userclass = userclass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getUserclass() {
        return userclass;
    }

    public void setUserclass(String userclass) {
        this.userclass = userclass;
    }
}