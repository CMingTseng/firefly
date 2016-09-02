package redix.firefly.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import redix.firefly.R;
import redix.firefly.object.ListClass;

/**
 * Created by thuyetpham94 on 02/09/2016.
 */
public class RecyclerListclassAdapter extends RecyclerView.Adapter<RecyclerListclassAdapter.RecyclerViewHolders> {

    ArrayList<ListClass> listclass;
    Context context;

    public RecyclerListclassAdapter(Context context,ArrayList<ListClass> listclass){
        this.context = context;
        this.listclass = listclass;
    }
    @Override
    public RecyclerListclassAdapter.RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler_listclass, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerListclassAdapter.RecyclerViewHolders holder, int position) {
        holder.imageView.setImageResource(listclass.get(position).getPhoto());
        holder.title.setText(listclass.get(position).getTitle());
        holder.address.setText(listclass.get(position).getAddress());
        holder.price.setText(listclass.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return listclass.size();
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView title;
        public TextView address;
        public TextView price;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_custom_recycler_listclass);
            title = (TextView)itemView.findViewById(R.id.txt_title_custom_recycler_listclass);
            address = (TextView)itemView.findViewById(R.id.txt_address_custom_reclycler_listclass);
            price = (TextView)itemView.findViewById(R.id.txt_price_custom_recyler_listclass);
        }
    }
}
