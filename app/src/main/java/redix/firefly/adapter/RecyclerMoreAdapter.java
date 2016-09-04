package redix.firefly.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import redix.firefly.R;

/**
 * Created by thuyetpham94 on 03/09/2016.
 */
public class RecyclerMoreAdapter extends RecyclerView.Adapter<RecyclerMoreAdapter.RecyclerViewHolders> {

    String[] listclass;
    Context context;
    public RecyclerMoreAdapter(Context context, String []listclass){
        this.context = context;
        this.listclass = listclass;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customrecyclermore, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.txt.setText(listclass[position]);
    }

    @Override
    public int getItemCount() {
        return listclass.length;
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder{
        public TextView txt;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.txt_customrecyclermore);
        }
    }
}
