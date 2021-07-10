package com.doodat.gfgheaderactionbar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.achep.header2actionbar.HeaderFragment;

// extending to HeaderFragment
public class Fragment extends HeaderFragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Handles the fading action of actionbar
        setHeaderBackgroundScrollMode(HEADER_BACKGROUND_SCROLL_PARALLAX);
        setOnHeaderScrollChangedListener(new OnHeaderScrollChangedListener() {
            @Override
            public void onHeaderScrollChanged(float progress, int height, int scroll) {
                height -= getActivity().getActionBar().getHeight();

                progress = (float) scroll / height;
                if (progress > 1f) progress = 1f;

                progress = (1 - (float) Math.cos(progress * Math.PI)) * 0.5f;

                ((MainActivity) getActivity())
                        .getFadingActionBarHelper()
                        .setActionBarAlpha((int) (255 * progress));
            }
        });
    }

    @Override
    public View onCreateHeaderView(LayoutInflater inflater, ViewGroup container) {
        // sets the header background of actionbar in expanded form
        return inflater.inflate(R.layout.fragment_header, container, false);
    }

    @Override
    public View onCreateContentView(LayoutInflater inflater, ViewGroup container) {
        // sets the main content below actionbar
        return inflater.inflate(R.layout.fragment_maincontent, container, false);
    }

    @Override
    public View onCreateContentOverlayView(LayoutInflater inflater, ViewGroup container) {
        return null;
    }
}