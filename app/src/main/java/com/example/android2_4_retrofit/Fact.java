package com.example.android2_4_retrofit;

import java.util.ArrayList;

public class Fact {
    private ArrayList<String> facts;
    private boolean success;

    public ArrayList<String> getFacts() {
        return facts;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setFacts(ArrayList<String> facts) {
        this.facts = facts;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Fact(){

    }
}
