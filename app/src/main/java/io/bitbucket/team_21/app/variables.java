package io.bitbucket.team_21.app;

import android.app.Application;

public class variables extends Application {
    private int data=2500;

    public int getData(){
        return this.data;
    }

    public void setData(int d){
        this.data=d;
    }
}