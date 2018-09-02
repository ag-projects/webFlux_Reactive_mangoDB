package com.agharibi.netflux.domain;

import lombok.Data;

import java.util.Date;


@Data
//@NoArgsConstructor
public class MovieEvent {

    private String movieId;
    private Date date;

    public MovieEvent(String movieId, Date date) {
        this.movieId = movieId;
        this.date = date;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
