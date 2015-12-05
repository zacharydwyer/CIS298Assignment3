package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class BeverageActivity extends SingleFragmentActivity {

    // Returns a BeverageFragment when the parent abstract template class needs it.
    @Override
    protected Fragment createFragment() {
        return new BeverageFragment();
    }
}
