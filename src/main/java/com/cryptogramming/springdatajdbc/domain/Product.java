package com.cryptogramming.springdatajdbc.domain;

import java.util.Date;


public class Product {
    private int id;
    private String imagePath;
    private String title;
    private String description;
    private String distributor;
    private Date releaseDate;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDistributor() { return distributor; }
    public void setDistributor(String distributor) { this.distributor = distributor; }

    public Date getReleaseDate() { return releaseDate; }
    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }
}
