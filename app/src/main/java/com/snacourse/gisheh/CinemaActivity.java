package com.snacourse.gisheh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.snacourse.gisheh.adapter.CinemaFilmAdapter;
import com.snacourse.gisheh.adapter.SaleFilmAdapter;
import com.snacourse.gisheh.crawler.CinemaCrawler;
import com.snacourse.gisheh.crawler.FilmSaleCrawler;
import com.snacourse.gisheh.model.CinemaFilm;
import com.snacourse.gisheh.model.CinemaFilmDataInterface;
import com.snacourse.gisheh.model.Film;
import com.snacourse.gisheh.model.SaleDataInterface;

import java.util.List;

/**
 * Created by a on 7/25/2017.
 */

public class CinemaActivity extends AppCompatActivity implements SaleDataInterface,CinemaFilmDataInterface {
RecyclerView recFilm,recSales;

CinemaCrawler cinemaCrawlr;
    FilmSaleCrawler filmSaleCrawler;






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinema_activity);
        recFilm= (RecyclerView) findViewById(R.id.recFilms);
        recSales= (RecyclerView) findViewById(R.id.recSale);


        GridLayoutManager mLayoutManager = new GridLayoutManager(this,3);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recFilm.setLayoutManager(mLayoutManager);



           LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(this);
        mLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recSales.setLayoutManager(mLayoutManager2);







        cinemaCrawlr=new CinemaCrawler(this);
         filmSaleCrawler=new FilmSaleCrawler(this);
        getDataFromSite();




    }

    private void getDataFromSite() {
        Thread tSale=new Thread(filmSaleCrawler);
        Thread tCinemaFilm=new Thread(cinemaCrawlr);

        tCinemaFilm.start();
        tSale.start();
    }


    @Override
    public void preparedDataSales(final List<Film> salesFilm) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                SaleFilmAdapter saleFilmAdapter=new SaleFilmAdapter(CinemaActivity.this,salesFilm);
                recSales.setAdapter(saleFilmAdapter);
                saleFilmAdapter.notifyDataSetChanged();


            }
        });



    }

    @Override
    public void onTapSale(Film film) {

    }

    @Override
    public void preparedDataCinemaFilm(final List<CinemaFilm> cinemaFilms) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                CinemaFilmAdapter cinemaFilmAdapter=new CinemaFilmAdapter(CinemaActivity.this,cinemaFilms);
                recFilm.setAdapter(cinemaFilmAdapter);
                cinemaFilmAdapter.notifyDataSetChanged();


            }
        });

    }

    @Override
    public void onTap(CinemaFilm cinemaFilm) {

    }
}