package redix.firefly;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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
 * Created by thuyetpham94 on 01/09/2016.
 */
public class LanguageFragment extends Fragment {
    private AutoScrollViewPager viewPager;
    private CustomPagerAdapter myViewPagerAdapter;
    List<Integer> images;
    RecyclerView recyclerlistclass;
    String[] abc = {"90000","80000","2000","3000"};
    public LanguageFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        images = new ArrayList<>();
        images.add(R.drawable.slide1);
        images.add(R.drawable.slide2);
        images.add(R.drawable.slide3);
        images.add(R.drawable.slide4);
        View view = inflater.inflate(R.layout.fragment_language_content, container, false);
        viewPager = (AutoScrollViewPager)view.findViewById(R.id.subviewpager_language);
        myViewPagerAdapter = new CustomPagerAdapter(getContext(),images);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setInterval(2000);
        viewPager.startAutoScroll();

        //recycle view
        ArrayList<ListClass> rowListItemgrenff = getList();
        recyclerlistclass = (RecyclerView)view.findViewById(R.id.recycle_listclass);
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
        ListClass listClass = new ListClass(R.drawable.slide1,"Lớp A","Minh Khai,Hà Nội","90000");
        ListClass listClass1 = new ListClass(R.drawable.slide2,"Lớp B","Minh Khai,Hà Nội","70000");
        ListClass listClass2 = new ListClass(R.drawable.slide3,"Lớp C","Minh Khai,Hà Nội","80000");
        ListClass listClass3 = new ListClass(R.drawable.slide4,"Lớp D","Minh Khai,Hà Nội","50000");
        ListClass listClass4 = new ListClass(R.drawable.slide5,"Lớp E","Minh Khai,Hà Nội","60000");
        ListClass listClass5 = new ListClass(R.drawable.slide1,"Lớp F","Minh Khai,Hà Nội","30000");
        list.add(listClass);
        list.add(listClass1);
        list.add(listClass2);
        list.add(listClass3);
        list.add(listClass4);
        list.add(listClass5);
        return list;
    }
}