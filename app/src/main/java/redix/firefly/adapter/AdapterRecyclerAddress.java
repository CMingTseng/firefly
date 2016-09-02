package redix.firefly.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import redix.firefly.R;
import redix.firefly.object.ItemObject;

/**
 * Created by thuyetpham94 on 02/09/2016.
 */
public class AdapterRecyclerAddress extends RecyclerView.Adapter<AdapterRecyclerAddress.RecyclerViewHolders> {
    private List<String> itemList;
    Context context;
    public AdapterRecyclerAddress(Context context,List<String> itemList){
        this.context=context;
        this.itemList = itemList;
    }
    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_dialog_address, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.address.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder{

        public TextView address;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            address = (TextView)itemView.findViewById(R.id.txt_address);
        }
    }
}
