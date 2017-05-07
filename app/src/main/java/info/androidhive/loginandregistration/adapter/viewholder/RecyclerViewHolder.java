package info.androidhive.loginandregistration.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import info.androidhive.loginandregistration.R;

/**
 * Created by Anis on 07/05/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView tv1;
    public TextView tv2;
    public ImageView imageView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        tv1 = (TextView) itemView.findViewById(R.id.list_title);
        tv2 = (TextView) itemView.findViewById(R.id.list_desc);
        imageView = (ImageView) itemView.findViewById(R.id.list_avatar);

    }
}