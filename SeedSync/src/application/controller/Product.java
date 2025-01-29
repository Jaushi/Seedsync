package application.controller;

public class Product {
    private String name;
    private float price;
    private String dateAdded;
    private float popularityRating;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, float price, String dateAdded, float popularityRating) {
        this.name = name;
        this.price = price;
        this.dateAdded = dateAdded;
        this.popularityRating = popularityRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public float getPopularityRating() {
        return popularityRating;
    }

    public void setPopularityRating(float popularityRating) {
        this.popularityRating = popularityRating;
    }
}