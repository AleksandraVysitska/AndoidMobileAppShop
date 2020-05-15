package com.example.negozio;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.negozio.fragment.TransformerFragment;

public class SectionAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SectionAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext=context;
    }


    //ci passa la posizione, equivale alla posizione di ViewPager
    @Override
    public Fragment getItem(int position) {
        Fragment selected = new Fragment();
        switch (position){//creiamo TransformerFragment
            case 0:
                selected = new TransformerFragment(0);
                break;
            case 1:
                selected = new TransformerFragment(1);
                break;
            case 2:
                selected = new TransformerFragment(2);
                break;
            default:
                selected = new TransformerFragment(3);
                break;
        }
        return selected;
    }


    //numero dei fragment
    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.tshirt);
            case 1:
                return mContext.getString(R.string.camicia);
            case 2:
                return mContext.getString(R.string.felpe);
            default:
                return mContext.getString(R.string.app_name);
        }
    }
}
