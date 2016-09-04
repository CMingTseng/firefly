package redix.firefly.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import redix.firefly.R;

/**
 * Created by thuyetpham94 on 04/09/2016.
 */
public class RecyclerTimelineAdapter extends RecyclerView.Adapter<RecyclerTimelineAdapter.RecyclerViewHolders>{

    Context context;
    int [] images;
    public  RecyclerTimelineAdapter(Context context,int [] images){
        this.context = context;
        this.images = images;
    }
    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler_timeline, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.img.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder{
        public ImageView img;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_custom_reclycler_timeline);
        }
    }
}
