package redix.firefly.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import redix.firefly.R;
import redix.firefly.object.ItemObject;

public class RecyclerViewYourClassAdapter extends RecyclerView.Adapter<RecyclerViewYourClassAdapter.RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;

    public RecyclerViewYourClassAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list_yourclass, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.className.setText(itemList.get(position).getName());
        holder.classPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder{

        public TextView className;
        public ImageView classPhoto;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            className = (TextView)itemView.findViewById(R.id.yourclass_name);
            classPhoto = (ImageView)itemView.findViewById(R.id.image_youclass);
        }
    }
}
