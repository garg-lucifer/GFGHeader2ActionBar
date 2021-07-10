package com.doodat.gfgheaderactionbar;
import android.app.Activity;
import android.os.Bundle;

import com.achep.header2actionbar.FadingActionBarHelper;

public class MainActivity extends Activity {

    private FadingActionBarHelper mFadingActionBarHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the header2actionbar FadingActionBarHelper
        mFadingActionBarHelper = new FadingActionBarHelper(getActionBar(),
                getResources().getDrawable(R.drawable.ab_background));
         // drawable sets the background of action bar in collapsed form

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new Fragment())
                    .commit();
        }

    }

    // getter for FadingActionBarHelper
    public FadingActionBarHelper getFadingActionBarHelper() {
        return mFadingActionBarHelper;
    }
}
