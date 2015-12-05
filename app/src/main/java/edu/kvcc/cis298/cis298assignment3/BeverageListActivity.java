package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.Fragment;

/**
 * Created by Zak Dwyer on 12/5/2015.
 */
public class BeverageListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new BeverageListFragment();
    }
}
