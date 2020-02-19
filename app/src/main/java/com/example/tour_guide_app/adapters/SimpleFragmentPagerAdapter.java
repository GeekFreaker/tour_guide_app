package com.example.tour_guide_app.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tour_guide_app.R;
import com.example.tour_guide_app.frags.CulturesFragment;
import com.example.tour_guide_app.frags.FlowersFragment;
import com.example.tour_guide_app.frags.HistoricalMonumentsFragment;
import com.example.tour_guide_app.frags.PoliticalPartiesFragment;
import com.example.tour_guide_app.frags.WildlifeFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private int [] TAB_TITLES =
            new int [] {R.string.strCultural,R.string.strFlowers,R.string.strHistorical,R.string.strWildLife,R.string.strPolitical};
    private static Context mContext;

    public SimpleFragmentPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CulturesFragment();
        } else if (position == 1) {
            return new FlowersFragment();
        } else if (position == 2) {
            return new HistoricalMonumentsFragment();
        } else if (position == 3) {
            return new WildlifeFragment();
        } else if (position == 4) {
            return new PoliticalPartiesFragment();
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
