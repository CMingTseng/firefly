package redix.firefly;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import redix.firefly.recyclerclick.RecyclerItemClickListener;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        //recycle view1
        RecyclerView rv_your_class = (RecyclerView)view.findViewById(R.id.viewpager_home);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        List<ItemObject> rowListItem = getAllItemList();
        rv_your_class.setHasFixedSize(true);
        rv_your_class.setLayoutManager(gridLayoutManager);
        rv_your_class.setAdapter(new RecyclerViewYourClassAdapter(getActivity(),rowListItem));
        //end
        //recycler view2
        RecyclerView recycler_grenffclass = (RecyclerView)view.findViewById(R.id.recycler_grenffclass);
        GridLayoutManager gridLayoutgrenff = new GridLayoutManager(getActivity(),2);
        List<ItemObject> rowListItemgrenff = getAllItemListGrenff();
        recycler_grenffclass.setHasFixedSize(true);
        recycler_grenffclass.setLayoutManager(gridLayoutgrenff);
        recycler_grenffclass.setAdapter(new RecyclerViewYourClassAdapter(getActivity(),rowListItemgrenff));
        recycler_grenffclass.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        if(position == 0){
                            callFragment(new LanguageActivity());
                        }
                        else if (position == 1){
                            callFragment(new ClubActivity());
                        }
                    }
                })
        );
        //end
        return view;
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
    public void callFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frameLayout_main, fragment);
        transaction.commit();
    }
}
