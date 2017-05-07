package info.androidhive.loginandregistration.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import info.androidhive.loginandregistration.R;
import info.androidhive.loginandregistration.adapter.viewholder.RecyclerViewHolder;
import info.androidhive.loginandregistration.model.Entity;

/**
 * Created by Anis on 07/05/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<info.androidhive.loginandregistration.adapter.viewholder.RecyclerViewHolder>{
        Context context;
    LayoutInflater inflater;
    ArrayList<Entity> arrayList;
    public RecyclerAdapter(Context context,ArrayList<Entity> arrayList) {
        this.context = context;
        this.arrayList=arrayList;
         inflater = LayoutInflater.from(context);
    }

    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_list, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }




    public void onBindViewHolder(info.androidhive.loginandregistration.adapter.viewholder.RecyclerViewHolder holder, int position) {

        holder.tv1.setText(arrayList.get(position).getTitle());
        holder.tv2.setText(arrayList.get(position).getInfo());
        holder.imageView.setOnClickListener(clickListener);
        holder.imageView.setTag(holder);
        /*
if (arrayList.get(position).getImage()!=null) {
    Glide
            .with(context)
            .load(arrayList.get(position).getImage())
            .into((ImageView) holder.imageView);
}*/
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
            int position = vholder.getPosition();

            Toast.makeText(context, "This is position " + position, Toast.LENGTH_LONG)
                    .show();

        }
    };
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}