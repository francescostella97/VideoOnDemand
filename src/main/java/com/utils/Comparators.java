package com.utils;

import com.model.FilmEntity;
import java.util.Comparator;

public class Comparators {
    public static class FilmDTOByNameAsc implements Comparator<FilmEntity> {

        @Override
        public int compare(FilmEntity film1, FilmEntity film2) {
            return film1.getTitle().compareTo(film2.getTitle());
        }
    }

    public static class FilmDTOByNameDesc implements Comparator<FilmEntity>{

        @Override
        public int compare(FilmEntity film1, FilmEntity film2) {
            return film2.getTitle().compareTo(film1.getTitle());
        }
    }

    public static class FilmDTOByYearAsc implements Comparator<FilmEntity>{

        @Override
        public int compare(FilmEntity film1, FilmEntity film2) {
            if(film1.getYear() > film2.getYear()){
                return 1;
            }
            else if (film1.getYear() < film2.getYear()){
                return -1;
            }
            else return 0;
        }
    }

    public static class FilmDTOByYearDesc implements Comparator<FilmEntity>{

        @Override
        public int compare(FilmEntity film1, FilmEntity film2) {
            if(film1.getYear() > film2.getYear()){
                return -1;
            }
            else if (film1.getYear() < film2.getYear()){
                return 1;
            }
            else return 0;
        }
    }
}
