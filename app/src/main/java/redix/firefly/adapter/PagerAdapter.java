package redix.firefly.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import redix.firefly.LanguageFragment;

/**
 * Created by thuyetpham94 on 01/09/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new LanguageFragment();
                break;
            case 1:
                frag=new LanguageFragment();
                break;
            case 2:
                frag=new LanguageFragment();
                break;
            case 3:
                frag=new LanguageFragment();
                break;
            case 4:
                frag=new LanguageFragment();
                break;
            case 5:
                frag=new LanguageFragment();
                break;
            case 6:
                frag=new LanguageFragment();
                break;
            case 7:
                frag=new LanguageFragment();
                break;
        }
        return frag;
    }
    @Override
    public int getCount() {
        return 8;
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