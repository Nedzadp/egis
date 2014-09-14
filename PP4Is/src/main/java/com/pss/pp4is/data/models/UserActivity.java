/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.models;

import java.sql.Timestamp;


/**
 *
 * @author Nedzad
 */
public class UserActivity {
    private int id;
    private Timestamp loggedIn;
    private Timestamp loggedOut;
    private int clockReset;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Timestamp loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Timestamp getLoggedOut() {
        return loggedOut;
    }

    public void setLoggedOut(Timestamp loggedOut) {
        this.loggedOut = loggedOut;
    }

    public int getClockReset() {
        return clockReset;
    }

    public void setClockReset(int clockReset) {
        this.clockReset = clockReset;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
