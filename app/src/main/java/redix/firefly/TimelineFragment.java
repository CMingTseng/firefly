package redix.firefly;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import redix.firefly.adapter.RecyclerTimelineAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment {


    RecyclerView recycler_fragment_timeline;

    int [] images = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3,R.drawable.slide4,R.drawable.slide5};
    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_timeline, container, false);
        recycler_fragment_timeline = (RecyclerView)view.findViewById(R.id.recycler_fragment_timeline);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recycler_fragment_timeline.setLayoutManager(gridLayoutManager);
        RecyclerTimelineAdapter recyclerTimelineAdapter = new RecyclerTimelineAdapter(getActivity(),images);
        recycler_fragment_timeline.setAdapter(recyclerTimelineAdapter);
        return view;
    }
}
