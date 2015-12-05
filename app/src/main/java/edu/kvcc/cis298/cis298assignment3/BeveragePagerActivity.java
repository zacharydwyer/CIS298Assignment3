package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by Zak Dwyer on 12/5/2015.
 */
public class BeveragePagerActivity extends FragmentActivity {

    private static final String EXTRA_BEVERAGE_ID = "edu.kvcc.cis298.cis298assignment3.beverage_id";

    private ViewPager mViewPager;
    private List<Beverage> mBeverageList;

    // Used to create an Intent that starts this Activity.
    public static Intent newIntent(Context packageContext, String crimeID) {
        Intent intentToStartSelf = new Intent(packageContext, BeveragePagerActivity.class);     // Intent to start this class
        intentToStartSelf.putExtra(EXTRA_BEVERAGE_ID, crimeID);                                 // Store given crimeID
        return intentToStartSelf;                                                               // Return appropriate, configured intent
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage_pager);

        /* GET WIDGET REFERENCES */
        mViewPager = (ViewPager) findViewById(R.id.activity_beverage_pager_view_pager);

        /* DATA REFERENCES */
        mBeverageList = Beverages.get(this).getBeverages();                                 // Get list of beverages
        FragmentManager supportFragmentManager = getSupportFragmentManager();               // Get support fragment manager
        mViewPager.setAdapter((new FragmentStatePagerAdapter(supportFragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Beverage beverage = mBeverageList.get(position);                            // Get the Beverage in the beverage list at the specified location
                return BeverageFragment.newInstance(beverage.getID());                      // Get a brand new detail Fragment that was created using the beverage's ID.
            }

            @Override
            public int getCount() {
                return mBeverageList.size();            // Just the size of the beverages list
            }
        }));
    }



}
