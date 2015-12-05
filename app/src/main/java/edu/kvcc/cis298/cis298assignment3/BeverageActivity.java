package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class BeverageActivity extends SingleFragmentActivity {

    // EXTRA ID
    public static final String EXTRA_BEVERAGE_ID = "edu.kvcc.cis298.cis298assignment3.beverage_id";

    // Returns a BeverageFragment when the parent abstract template class needs it.
    @Override
    protected Fragment createFragment() {
        return new BeverageFragment();
    }

    // Use this method to get an Intent to start this Activity. Needs the beverage ID.
    public static Intent newIntent(Context packageContent, String beverageID) {
        Intent intentToStartSelf = new Intent(packageContent, BeverageActivity.class);
        intentToStartSelf.putExtra(EXTRA_BEVERAGE_ID, beverageID);                          // Stores beverageID using special ID identifier
        return intentToStartSelf;
    }
}
