package redix.firefly;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gigamole.navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import redix.firefly.adapter.AdapterRecyclerAddress;
import redix.firefly.autoviewpager.AutoScrollViewPager;

public class MainAllActivity extends FragmentActivity {
    private TextView[] dots;
    private List<Integer> imageIdList;
    private List<String> list_address;
    private AutoScrollViewPager viewPager;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //navigation bottom
        final String[] colors = getResources().getStringArray(R.array.default_preview);
        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.tab_main);
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
                if(index == 0){
                    callFragment(new MainFragment());
                    RelativeLayout relative_menutop = (RelativeLayout)findViewById(R.id.relative_menutop);
                    relative_menutop.setVisibility(View.VISIBLE);
                } else if(index == 1){
                    callFragment(new TimelineFragment());
                    RelativeLayout relative_menutop = (RelativeLayout)findViewById(R.id.relative_menutop);
                    relative_menutop.setVisibility(View.VISIBLE);
                }else if(index == 4){
                    callFragment(new MoreFragment());
                    RelativeLayout relative_menutop = (RelativeLayout)findViewById(R.id.relative_menutop);
                    relative_menutop.setVisibility(View.GONE);
                }
            }
            @Override
            public void onEndTabSelected(final NavigationTabBar.Model model, final int index) {
                model.hideBadge();
            }
        });
//        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
//
//            }
//            @Override
//            public void onPageSelected(final int position) {
//
//            }
//            @Override
//            public void onPageScrollStateChanged(final int state) {
//
//            }
//        });
        //end

        //event show dialog list province
        TextView txt_listprovince = (TextView)findViewById(R.id.txt_listprovince);
        txt_listprovince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list_address = Arrays.asList(getResources().getStringArray(R.array.ArrayProvince));

                final Dialog dialog = new Dialog(MainAllActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialogaddress);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                search = (EditText)dialog.findViewById(R.id.edittext_search_dialogaddress);
                final RecyclerView recycler_province = (RecyclerView)dialog.findViewById(R.id.recycler_province);
                LinearLayoutManager linear_province = new LinearLayoutManager(MainAllActivity.this);
                recycler_province.setLayoutManager(linear_province);
                AdapterRecyclerAddress adapter_address = new AdapterRecyclerAddress(MainAllActivity.this,list_address);
                recycler_province.setAdapter(adapter_address);
                //search
                search.addTextChangedListener(new TextWatcher() {
                    public void afterTextChanged(Editable s) {}
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                    public void onTextChanged(CharSequence query, int start, int before, int count) {
                        query = query.toString().toLowerCase();
                        final List<String> filteredList = new ArrayList<>();
                        for (int i = 0; i < list_address.size(); i++) {
                            final String text = list_address.get(i).toLowerCase();
                            if (text.contains(query)) {
                                filteredList.add(list_address.get(i));
                            }
                        }
                        recycler_province.setLayoutManager(new LinearLayoutManager(MainAllActivity.this));
                        AdapterRecyclerAddress adapter_address2 = new AdapterRecyclerAddress(MainAllActivity.this,filteredList);
                        recycler_province.setAdapter(adapter_address2);
                        adapter_address2.notifyDataSetChanged();  // data set changed
                    }
                });
                //end
            }
        });
        //end
        //call fragment
        callFragment(new MainFragment());
    }

    public void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frameLayout_main, fragment);
        transaction.commit();
    }
}
