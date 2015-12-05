package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BeverageActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage);

        FragmentManager fragmentManager = getSupportFragmentManager();                      // Get support version of this activity's fragment manager
        Fragment myFragment = fragmentManager.findFragmentById(R.id.fragmentContainer);     // Fragments are identified using the container they're about to be put in.

        if (myFragment == null) {
            myFragment = new BeverageFragment();                // Create a new Fragment for BeverageActivity to hold if there wasn't already one created

            fragmentManager.beginTransaction()                  // Start a fragment transaction, add this fragment to the fragment manager, then finalize the operation.
                    .add(R.id.fragmentContainer, myFragment)
                    .commit();
        }
    }
}
