package com.snacourse.gisheh.crawler;


import com.snacourse.gisheh.model.Film;
import com.snacourse.gisheh.model.SaleDataInterface;
import com.snacourse.gisheh.utils.ChangeBrowser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmSaleCrawler implements Runnable {
    SaleDataInterface saleDataInterface;

    public FilmSaleCrawler(SaleDataInterface saleDataInterface) {
        this.saleDataInterface = saleDataInterface;
    }

    public void getFilmSale(){

        List<Film> films=null;

        String userAgent=  ChangeBrowser.getInstance().selectRandomFromBrowser();
        try {
            Document doc=  Jsoup.connect("https://www.cinematicket.org/?p=boxoffice")
                    .userAgent(userAgent)
                    .timeout(25000)
                    .get();

            Elements elSelection= doc.select("table.tabel").first().select("tr");
            System.out.println(elSelection.size());

           films=new ArrayList<Film>(elSelection.size()-1);
            //
          elSelection.remove(0);
            int counter=0;
            for (Element el:elSelection){
                Elements  elTD  =el.children();
               Element tdRank=elTD.get(0);
                Element tdFilmURL=elTD.get(1);
                Element tdDirector=elTD.get(2);
                Element tdWeeks=elTD.get(3);
                Element tdWeeklySale=elTD.get(4);
                Element tdtotal=elTD.get(5);

           int  rank= Integer.parseInt(tdRank.text().trim());
           String filmTitle  =tdFilmURL.text();

                String filmLink= tdFilmURL .select("a[href]").first() .attr("abs:href");
                String director  =tdDirector.text();

                int  weeks= Integer.parseInt(tdWeeks.text().trim());
               String weeklySales=tdWeeklySale.text();
                String totalSale=tdtotal.text();


Film film=new Film();
film.setId(counter);
film.setRank(rank);
film.setFilmURL(filmLink);
film.setTitle(filmTitle+director);
film.setWeeks(weeks);
film.setWeeks(weeks);
film.setWeeklySale(weeklySales);
film.setTotalsale(totalSale);

films.add(counter,film);
              //  System.out.println(filmLink+'\n'+rank+'\n'+filmTitle+'\n'+director+'\n'+weeks+'\n'+weeklySales+'\n'+totalSale+'\n'+'\n');



                counter++;


            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        saleDataInterface.preparedDataSales(films);
    }

    @Override
    public void run() {
        getFilmSale();
    }

  /*  public static void main(String[] args) {
        FilmSaleCrawler filmSaleCrawler=new FilmSaleCrawler();
                filmSaleCrawler.getFilmSale();
    }*/
}
