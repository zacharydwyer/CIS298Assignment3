package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class BeverageActivity extends SingleFragmentActivity {

    // EXTRA ID
    private static final String EXTRA_BEVERAGE_ID = "edu.kvcc.cis298.cis298assignment3.beverage_id";

    // Creates a new fragment with a given
    @Override
    protected Fragment createFragment() {
        String beverageID = (String) getIntent().getSerializableExtra(EXTRA_BEVERAGE_ID);   // BeverageID retrieved from what called it. Should be using the newIntent method!
        return BeverageFragment.newInstance(beverageID);                                    // Create a new BeverageFragment using the beverageID.

    }

    // Use this method to get an Intent to start this Activity. Needs the beverage ID. Should be the ONLY way you get an Intent to start this activity!
    public static Intent newIntent(Context packageContent, String beverageID) {
        Intent intentToStartSelf = new Intent(packageContent, BeverageActivity.class);
        intentToStartSelf.putExtra(EXTRA_BEVERAGE_ID, beverageID);                          // Stores beverageID using special ID identifier
        return intentToStartSelf;
    }
}
