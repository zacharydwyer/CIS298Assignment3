package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

// A starting point for an Activity that hosts only one Fragment.
public abstract class SingleFragmentActivity extends FragmentActivity {

    // Whatever class implements this class must provide a way to create a Fragment.
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment_layout);                                             // Layout is basic, only has one area to draw a fragment.
        FragmentManager manager = getSupportFragmentManager();                                  // Get the fragment manager from this activity
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = createFragment();                    // This is where it gets the special Fragment - either a ListFragment or a DetailViewFragment.
            manager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

}
