package com.model;

import javax.persistence.*;

@Entity
@Table(name = "FILM")
public class FilmEntity extends BaseEntityAudit{

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="genere_id")
    private GenreEntity genre;

    @Column(name = "year")
    private int year;

    @Column(name = "producer")
    private String producer;

    @Column(name = "cast")
    private String cast;

    @Column(name = "length")
    private int length;

    @Column(name = "description")
    private String description;

    @Column(name = "cover")
    private String cover;

    public FilmEntity() {
    }

    public String getTitle() {
        return title;
    }

    public FilmEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public FilmEntity setPrice(double price) {
        this.price = price;
        return this;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public FilmEntity setGenre(GenreEntity genre) {
        this.genre = genre;
        return this;
    }

    public int getYear() {
        return year;
    }

    public FilmEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public FilmEntity setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public String getCast() {
        return cast;
    }

    public FilmEntity setCast(String cast) {
        this.cast = cast;
        return this;
    }

    public int getLength() {
        return length;
    }

    public FilmEntity setLength(int length) {
        this.length = length;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FilmEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public FilmEntity setCover(String cover) {
        this.cover = cover;
        return this;
    }

    @Override
    public String toString() {
        return "FilmEntity{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", genre=" + genre.getName() +
                ", year=" + year +
                ", producer='" + producer + '\'' +
                ", cast='" + cast + '\'' +
                ", length=" + length +
                ", description='" + description + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}
