package com.snacourse.gisheh.crawler;



import com.snacourse.gisheh.model.CinemaFilm;
import com.snacourse.gisheh.model.CinemaFilmDataInterface;
import com.snacourse.gisheh.utils.ChangeBrowser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CinemaCrawler  implements Runnable {
    List<String> usersAgent;

    CinemaFilmDataInterface cinemaFilmDataInterface;
    public CinemaCrawler(CinemaFilmDataInterface cinemaFilmDataInterface) {
this.cinemaFilmDataInterface=cinemaFilmDataInterface;
    }

    public void getFilms(){
        List<CinemaFilm> cinemaFilms = null;


        String userAgent=  ChangeBrowser.getInstance().selectRandomFromBrowser();
        try {
            Document doc=  Jsoup.connect("https://www.cinematicket.org/?p=nfilms")
                    .userAgent(userAgent)
                    .timeout(25000)
                    .get();


/*<section class="col--small-12 col--medium-8 col--large-9">*/

     //  Elements elSelection= doc.select("section.section--movie");
       Elements elSelection= doc.select("figure.grid-card");

 cinemaFilms=new ArrayList<CinemaFilm>(elSelection.size());
          //  System.out.println(elSelection.size());
            int counter=0;
       for (Element el:elSelection){

      String resrveLink=     el.select("a[href]").first().attr("abs:href");
      String cover=    el.select("div.cover").first() .select("img[src]").first().attr("abs:src");
           Elements elFig=  el.select("figcaption.card-2-caption").first().children();
     String title= elFig.get(0).text();
           String director= elFig.get(1).text();
           CinemaFilm cinema=new CinemaFilm();
           cinema.setReserveUrl(resrveLink);
           cinema.setPosterURl(cover);
           cinema.setId(counter);
           cinema.setTitle(title);
           cinema.setDirector(director);
       cinemaFilms.add(counter,cinema)    ;

counter++;


       }


        } catch (IOException e) {
            e.printStackTrace();
        }

        cinemaFilmDataInterface.preparedDataCinemaFilm(cinemaFilms);
    }

  /*  public static void main(String[] args) {
        CinemaCrawler cinemaCrawler=new CinemaCrawler();
        cinemaCrawler.getFilms();
    }*/

    @Override
    public void run() {
        getFilms();
    }
}
