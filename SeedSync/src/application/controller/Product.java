package application.controller;

public class Product {
    private String pictureURL;
    private String name;
    private String location;
    private float weight;
    private float price;
    private String user_id;

    public Product(String pictureURL, String name, String location, float weight, float price, String user_id) {
        this.pictureURL = pictureURL;
        this.name = name;
        this.location = location;
        this.weight = weight;
        this.price = price;
        this.user_id = user_id;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}