package redix.firefly;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.xiaopan.psts.PagerSlidingTabStrip;
import redix.firefly.adapter.ClubPagerAdapter;
import redix.firefly.adapter.PagerAdapter;

public class ClubActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_club, container, false);
        //view pager
        PagerSlidingTabStrip pagerSlidingTabStrip1 = (PagerSlidingTabStrip)view.findViewById(R.id.club_tab);
        ViewPager viewPager1 = (ViewPager)view.findViewById(R.id.viewpager_club);
        init(0, pagerSlidingTabStrip1, viewPager1);
        //end
        return view;
    }

    //function view pager
    private void init(int index, PagerSlidingTabStrip pagerSlidingTabStrip, ViewPager viewPager){
        int length = pagerSlidingTabStrip.getTabCount();
        viewPager.setAdapter(new ClubPagerAdapter(getActivity().getSupportFragmentManager()));
        viewPager.setCurrentItem(index < length ? index : length);
        pagerSlidingTabStrip.setViewPager(viewPager);
    }
}
