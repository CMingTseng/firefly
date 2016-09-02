package redix.firefly;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gigamole.navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import redix.firefly.adapter.AdapterRecyclerAddress;
import redix.firefly.adapter.CustomPagerAdapter;
import redix.firefly.adapter.RecyclerViewYourClassAdapter;
import redix.firefly.autoviewpager.AutoScrollViewPager;
import redix.firefly.object.ItemObject;

public class MainActivity extends AppCompatActivity {
    //private LinearLayout dotsLayout;
    private TextView[] dots;
    private List<Integer> imageIdList;
    private List<String> list_address;
    private AutoScrollViewPager viewPager;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recycle view1
        RecyclerView rv_your_class = (RecyclerView)findViewById(R.id.viewpager_home);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2);
        List<ItemObject> rowListItem = getAllItemList();
        rv_your_class.setHasFixedSize(true);
        rv_your_class.setLayoutManager(gridLayoutManager);
        rv_your_class.setAdapter(new RecyclerViewYourClassAdapter(MainActivity.this,rowListItem));
        //end
        //recycler view2
        RecyclerView recycler_grenffclass = (RecyclerView)findViewById(R.id.recycler_grenffclass);
        GridLayoutManager gridLayoutgrenff = new GridLayoutManager(MainActivity.this,2);
        List<ItemObject> rowListItemgrenff = getAllItemListGrenff();
        recycler_grenffclass.setHasFixedSize(true);
        recycler_grenffclass.setLayoutManager(gridLayoutgrenff);
        recycler_grenffclass.setAdapter(new RecyclerViewYourClassAdapter(MainActivity.this,rowListItemgrenff));
        //end
        //event show dialog list province
        TextView txt_listprovince = (TextView)findViewById(R.id.txt_listprovince);
        txt_listprovince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list_address = Arrays.asList(getResources().getStringArray(R.array.ArrayProvince));

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialogaddress);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                search = (EditText)dialog.findViewById(R.id.edittext_search_dialogaddress);
                final RecyclerView recycler_province = (RecyclerView)dialog.findViewById(R.id.recycler_province);
                LinearLayoutManager linear_province = new LinearLayoutManager(MainActivity.this);
                recycler_province.setLayoutManager(linear_province);
                AdapterRecyclerAddress adapter_address = new AdapterRecyclerAddress(MainActivity.this,list_address);
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


                        recycler_province.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        AdapterRecyclerAddress adapter_address2 = new AdapterRecyclerAddress(MainActivity.this,filteredList);
                        recycler_province.setAdapter(adapter_address2);
                        adapter_address2.notifyDataSetChanged();  // data set changed
                    }
                });
                //end
            }
        });
        //end
        //navigation bottom
        final String[] colors = getResources().getStringArray(R.array.default_preview);
        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.tabbar);
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
    private List<ItemObject> getAllItemList(){
        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Lớp A", R.drawable.slide1));
        allItems.add(new ItemObject("Lớp B", R.drawable.slide2));
        return allItems;
    }
    private List<ItemObject> getAllItemListGrenff(){
        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Ngôn ngữ", R.drawable.slide1));
        allItems.add(new ItemObject("Câu lạc bộ", R.drawable.slide2));
        allItems.add(new ItemObject("Thể thao", R.drawable.slide3));
        return allItems;
    }
}
