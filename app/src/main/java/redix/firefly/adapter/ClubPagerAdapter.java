package redix.firefly.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import redix.firefly.ClubFragment;
import redix.firefly.LanguageFragment;

/**
 * Created by thuyetpham94 on 01/09/2016.
 */
public class ClubPagerAdapter extends FragmentStatePagerAdapter {
    public ClubPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new ClubFragment();
                break;
            case 1:
                frag=new ClubFragment();
                break;
            case 2:
                frag=new ClubFragment();
                break;
            case 3:
                frag=new ClubFragment();
                break;
            case 4:
                frag=new ClubFragment();
                break;
            case 5:
                frag=new ClubFragment();
                break;
        }
        return frag;
    }
    @Override
    public int getCount() {
        return 6;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title="Android";
                break;
            case 1:
                title="IOS";
                break;
            case 2:
                title="PHP";
                break;
        }

        return title;
    }

}