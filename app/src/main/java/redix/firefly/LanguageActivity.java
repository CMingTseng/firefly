package redix.firefly;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import me.xiaopan.psts.PagerSlidingTabStrip;
import redix.firefly.adapter.PagerAdapter;

public class LanguageActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_language, container, false);
        //view pager
        PagerSlidingTabStrip pagerSlidingTabStrip1 = (PagerSlidingTabStrip)view.findViewById(R.id.language_tab);
        ViewPager viewPager1 = (ViewPager)view.findViewById(R.id.viewpager_language);
        init(0, pagerSlidingTabStrip1, viewPager1);

        //menu top
        ImageView icon_app = (ImageView)getActivity().findViewById(R.id.img_icon_app);
        icon_app.setImageResource(R.drawable.back_interact);
        icon_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callFragment(new MainFragment());
            }
        });
        //end
        return view;
    }
    //function view pager
    private void init(int index, PagerSlidingTabStrip pagerSlidingTabStrip, ViewPager viewPager){
        int length = pagerSlidingTabStrip.getTabCount();
        viewPager.setAdapter(new PagerAdapter(getActivity().getSupportFragmentManager()));
        viewPager.setCurrentItem(index < length ? index : length);
        pagerSlidingTabStrip.setViewPager(viewPager);
    }

    public void callFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frameLayout_main, fragment);
        transaction.commit();
    }
}
