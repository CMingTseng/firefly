package redix.firefly;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import redix.firefly.adapter.RecyclerMoreAdapter;

/**
 * Created by thuyetpham94 on 03/09/2016.
 */
public class MoreFragment extends Fragment {

    String [] listclass = {"Lớp học nhạc","Lớp học vẽ","Lớp học đàn","Lớp học võ"};
    RecyclerView recyclerclass;
    TextView txt_create_class;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.framemore, container, false);
        recyclerclass = (RecyclerView)view.findViewById(R.id.recycler_class);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerclass.setLayoutManager(linearLayoutManager);
        recyclerclass.setHasFixedSize(true);
        RecyclerMoreAdapter recyclerMoreAdapter = new RecyclerMoreAdapter(getActivity(),listclass);
        recyclerclass.setAdapter(recyclerMoreAdapter);

        txt_create_class = (TextView)view.findViewById(R.id.txt_create_class);
        txt_create_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ClassActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
}
