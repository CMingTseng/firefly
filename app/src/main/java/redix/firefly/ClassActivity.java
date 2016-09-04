package redix.firefly;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.gigamole.navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;

public class ClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        //navigation bottom
        final String[] colors = getResources().getStringArray(R.array.default_preview);
        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.tab_class);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon_upload),
                        Color.parseColor(colors[0]))
                        .title("Heart")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon_save),
                        Color.parseColor(colors[1]))
                        .title("Cup")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon_delete),
                        Color.parseColor(colors[2]))
                        .title("Diploma")
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
                if(index == 0){

                } else if(index == 4){
//                    callFragment(new MoreFragment());
//                    RelativeLayout relative_menutop = (RelativeLayout)findViewById(R.id.relative_menutop);
//                    relative_menutop.setVisibility(View.GONE);
                }
            }
            @Override
            public void onEndTabSelected(final NavigationTabBar.Model model, final int index) {
                model.hideBadge();
            }
        });
    }
}
