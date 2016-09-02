package redix.firefly;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gigamole.navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.xiaopan.psts.PagerSlidingTabStrip;
import redix.firefly.adapter.PagerAdapter;

public class LanguageActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        //view pager
        PagerSlidingTabStrip pagerSlidingTabStrip1 = (PagerSlidingTabStrip) findViewById(R.id.language_tab);
        ViewPager viewPager1 = (ViewPager) findViewById(R.id.viewpager_language);
        init(0, pagerSlidingTabStrip1, viewPager1);
        //end
        //navigation tab bottom
        final String[] colors = getResources().getStringArray(R.array.default_preview);
        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.home),
                        Color.parseColor(colors[0]))
                        .title("Heart")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.friends),
                        Color.parseColor(colors[1]))
                        .title("Cup")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon_search),
                        Color.parseColor(colors[2]))
                        .title("Diploma")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon_notifications),
                        Color.parseColor(colors[3]))
                        .title("Flag")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon_more),
                        Color.parseColor(colors[4]))
                        .title("Medal")
                        .build()
        );

        navigationTabBar.setModels(models);

        // Set gạt tab thì chuyển icon menu tabbar bottom bên dưới
        //navigationTabBar.setViewPager(viewPager1, 2);
        //------------------end--------------------------------

        //IMPORTANT: ENABLE SCROLL BEHAVIOUR IN COORDINATOR LAYOUT
        // set trượt recycle view ẩn menu tabbar icon ở dưới.
        navigationTabBar.setBehaviorEnabled(true);
        //-----------------------end-----------------

        navigationTabBar.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
            @Override
            public void onStartTabSelected(final NavigationTabBar.Model model, final int index) {
            }

            @Override
            public void onEndTabSelected(final NavigationTabBar.Model model, final int index) {
                model.hideBadge();
            }
        });
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });
        //end
    }
    //function view pager
    private void init(int index, PagerSlidingTabStrip pagerSlidingTabStrip, ViewPager viewPager){
        int length = pagerSlidingTabStrip.getTabCount();
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(index < length ? index : length);
        pagerSlidingTabStrip.setViewPager(viewPager);
    }
}
