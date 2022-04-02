package com.company;

import java.util.ArrayList;
import java.util.Collections;
public class Sorter {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie(9.0,"Seperti Dendam, Rindu Harus Dibayar Tuntas",2021));
        list.add(new Movie(8.4,"Joker",2019));
        list.add(new Movie(6.6,"Maleficent: Mistress of Evil",2019));
        list.add(new Movie(9.1,"The Dark Knight",2008));
        list.add(new Movie(8.6,"The Silence of the Lambs",1991));

        System.out.println("Film sebelum pengurutan : ");
        for (Movie movie: list){
            System.out.println(movie.getName() + "-" + movie.getRating() + "-" + movie.getYear());
        }

        Collections.sort(list);
        System.out.println("\nMovies after sorting : ");
        for(Movie movie: list){
            System.out.println(movie.getName() + "-" + movie.getRating() + "-" + movie.getYear());
        }


    }
}
