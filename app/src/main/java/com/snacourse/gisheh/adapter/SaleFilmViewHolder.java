package com.snacourse.gisheh.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.snacourse.gisheh.R;


/**
 * Created by Sh-Java on 12/10/2016.
 */
public class SaleFilmViewHolder extends RecyclerView.ViewHolder {


    View itemView;

    TextView textTitle;
    TextView textRank;
    TextView textWeeks;
    TextView textSaloon;
    TextView textWeekly;
    TextView textTotal;





    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }

    public SaleFilmViewHolder(View itemView) {
        super(itemView);
        this.itemView=itemView;
        this.textTitle = (TextView) itemView.findViewById(R.id.textTitle);
        this.textRank = (TextView) itemView.findViewById(R.id.textRank);
        this.textWeeks = (TextView) itemView.findViewById(R.id.textWeeks);
        this.textSaloon = (TextView) itemView.findViewById(R.id.textSaloon);
        this.textWeekly = (TextView) itemView.findViewById(R.id.textWeekly);
        this.textTotal = (TextView) itemView.findViewById(R.id.textTotal);

    }
}
