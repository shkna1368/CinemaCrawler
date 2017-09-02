package com.snacourse.gisheh.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.snacourse.gisheh.R;
import com.snacourse.gisheh.model.CinemaFilm;
import com.snacourse.gisheh.model.CinemaFilmDataInterface;

import java.util.List;

/**
 * Created by Sh-Java on 12/10/2016.
 */
public class CinemaFilmAdapter extends RecyclerView.Adapter<CinemaFilmViewHolder>  {
    private List<CinemaFilm> cinemaFilms;
    CinemaFilmDataInterface cinemaFilmDataInterface;
    Context ctx;


   // private EventBus bus = EventBus.getDefault();

    @Override
    public CinemaFilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_row, parent, false);
 ctx=view.getContext();


        CinemaFilmViewHolder myViewHolder = new CinemaFilmViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final CinemaFilmViewHolder holder, int position) {
        TextView textTitle = holder.textTitle;
        TextView textDirector = holder.textDirector;




  final CinemaFilm  cinemaFilm=cinemaFilms.get(position);
        textTitle.setText(cinemaFilm.getTitle());
        textDirector.setText(cinemaFilm.getDirector());
      //  textDistance.setText((int)place.getDistance()+" m");

        Glide.with(ctx).load(cinemaFilm.getPosterURl())
                .thumbnail(0.5f)
                .crossFade()
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.cover);





        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cinemaFilmDataInterface.onTap(cinemaFilm);


            }
        });


        holder.getItemView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                cinemaFilmDataInterface.onTap(cinemaFilm);
                return false;
            }


        });







    }

    public CinemaFilmAdapter(Activity ctx, List<CinemaFilm> cinemaFilms) {
        this.cinemaFilms = cinemaFilms;
this.ctx=ctx;
        this.cinemaFilmDataInterface= (CinemaFilmDataInterface) ctx;
    }

    @Override
    public int getItemCount() {
        return cinemaFilms.size();
    }



}
