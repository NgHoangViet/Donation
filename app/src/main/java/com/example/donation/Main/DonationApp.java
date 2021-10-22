package com.example.donation.Main;

import android.app.Application;
import android.widget.Toast;

import com.example.donation.Database.DBManager;
import com.example.donation.Model.Donation;

public class DonationApp extends Application {
    public final int target = 10000;
    public int totalDonated = 0;
    public DBManager dbManager;

    public boolean newDonation(Donation donation) {
        boolean targetAchieved = totalDonated > target;
        if(!targetAchieved) {
            dbManager.add(donation);
            totalDonated += donation.amount;
        }else {
            Toast.makeText(this, "Target Exceeded", Toast.LENGTH_SHORT).show();
        }
        return targetAchieved;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dbManager = new DBManager(this);
    }
}
