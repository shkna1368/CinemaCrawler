package com.snacourse.gisheh.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.snacourse.gisheh.R;


/**
 * Created by Sh-Java on 12/10/2016.
 */
public class CinemaFilmViewHolder extends RecyclerView.ViewHolder {

    TextView textTitle;
    TextView textDirector;

    ImageView cover;
    View itemView;




    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }

    public CinemaFilmViewHolder(View itemView) {
        super(itemView);
        this.itemView=itemView;
        this.textTitle = (TextView) itemView.findViewById(R.id.title);
        this.textDirector = (TextView) itemView.findViewById(R.id.director);
        this.cover = (ImageView) itemView.findViewById(R.id.cover);



    }
}
