package com.snacourse.gisheh.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.snacourse.gisheh.R;
import com.snacourse.gisheh.model.Film;
import com.snacourse.gisheh.model.SaleDataInterface;

import java.util.List;

/**
 * Created by Sh-Java on 12/10/2016.
 */
public class SaleFilmAdapter extends RecyclerView.Adapter<SaleFilmViewHolder>  {
    private List<Film> films;
    SaleDataInterface saleDataInterface;
    Context ctx;


   // private EventBus bus = EventBus.getDefault();

    @Override
    public SaleFilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sale_row, parent, false);
 ctx=view.getContext();


        SaleFilmViewHolder myViewHolder = new SaleFilmViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final SaleFilmViewHolder holder, int position) {
        TextView textTitle = holder.textTitle;
        TextView textRank = holder.textRank;
        TextView textSaloon = holder.textSaloon;
        TextView textWeekly = holder.textWeekly;
        TextView textWeeks = holder.textWeeks;
        TextView textTotal = holder.textTotal;





  final Film  film=films.get(position);
        textTitle.setText(film.getTitle());
        Log.e("rank=",film.getRank()+"");
        textRank.setText(film.getRank()+"");
        textSaloon.setText(film.getSaloonNumber()+"");
        textWeekly.setText(film.getWeeklySale());
        textWeeks.setText(film.getWeeks()+"");
        textTotal.setText(film.getTotalsale()+"");




        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saleDataInterface.onTapSale(film);


            }
        });


        holder.getItemView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                saleDataInterface.onTapSale(film);
                return false;
            }


        });







    }

    public SaleFilmAdapter(Activity ctx, List<Film> films) {
        this.films = films;
this.ctx=ctx;
        this.saleDataInterface= (SaleDataInterface) ctx;
    }

    @Override
    public int getItemCount() {
        return films.size();
    }



}
