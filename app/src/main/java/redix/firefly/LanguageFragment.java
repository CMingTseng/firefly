package redix.firefly;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import redix.firefly.adapter.CustomPagerAdapter;
import redix.firefly.autoviewpager.AutoScrollViewPager;

/**
 * Created by thuyetpham94 on 01/09/2016.
 */
public class LanguageFragment extends Fragment {
    private AutoScrollViewPager viewPager;
    private CustomPagerAdapter myViewPagerAdapter;
    List<Integer> images;
    RecyclerView recyclerlistclass;
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
        recyclerlistclass = (RecyclerView)view.findViewById(R.id.recycle_listclass);
        myViewPagerAdapter = new CustomPagerAdapter(getContext(),images);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setInterval(2000);
        viewPager.startAutoScroll();

        //recycle view

        //end
        return view;

    }
}