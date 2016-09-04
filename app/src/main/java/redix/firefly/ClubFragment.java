package redix.firefly;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import redix.firefly.adapter.CustomPagerAdapter;
import redix.firefly.adapter.RecyclerListclassAdapter;
import redix.firefly.autoviewpager.AutoScrollViewPager;
import redix.firefly.object.ListClass;

/**
 * Created by thuyetpham94 on 03/09/2016.
 */
public class ClubFragment extends Fragment {
    private AutoScrollViewPager viewPager;
    private CustomPagerAdapter myViewPagerAdapter;
    List<Integer> images;
    RecyclerView recyclerlistclass;
    String[] abc = {"90000","80000","2000","3000"};
    public ClubFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        images = new ArrayList<>();
        images.add(R.drawable.slide1);
        images.add(R.drawable.slide2);
        images.add(R.drawable.slide3);
        images.add(R.drawable.slide4);
        View view = inflater.inflate(R.layout.fragment_club, container, false);
        viewPager = (AutoScrollViewPager)view.findViewById(R.id.subviewpager_club);
        myViewPagerAdapter = new CustomPagerAdapter(getContext(),images);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setInterval(2000);
        viewPager.startAutoScroll();

        //recycle view
        ArrayList<ListClass> rowListItemgrenff = getList();
        recyclerlistclass = (RecyclerView)view.findViewById(R.id.recycle_list);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerlistclass.setLayoutManager(linearLayoutManager);
        recyclerlistclass.setHasFixedSize(true);
        RecyclerListclassAdapter listclass= new RecyclerListclassAdapter(getContext(),rowListItemgrenff);
        recyclerlistclass.setAdapter(listclass);
        //end
        return view;
    }

    public ArrayList<ListClass> getList(){
        ArrayList<ListClass> list = new ArrayList<>();
        ListClass listClass = new ListClass(R.drawable.slide1,"club võ thuật","Minh Khai,Hà Nội","90000");
        ListClass listClass1 = new ListClass(R.drawable.slide2,"club học đàn","Minh Khai,Hà Nội","70000");
        ListClass listClass2 = new ListClass(R.drawable.slide3,"club học nhảy","Minh Khai,Hà Nội","80000");
        ListClass listClass3 = new ListClass(R.drawable.slide4,"club boxing","Minh Khai,Hà Nội","50000");
        ListClass listClass4 = new ListClass(R.drawable.slide5,"club dạy vẽ","Minh Khai,Hà Nội","60000");
        ListClass listClass5 = new ListClass(R.drawable.slide1,"club học tiếng","Minh Khai,Hà Nội","30000");
        list.add(listClass);
        list.add(listClass1);
        list.add(listClass2);
        list.add(listClass3);
        list.add(listClass4);
        list.add(listClass5);
        return list;
    }
}