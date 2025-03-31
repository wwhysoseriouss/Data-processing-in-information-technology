package model;

public class Shoe {
    private String brand;
    private String model;
    private double price;
    private String size;
    private String imageUrl;

    public Shoe(String brand, String model, double price, String size, String imageUrl) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.size = size;
        this.imageUrl = imageUrl;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
    public String getSize() { return size; }
    public String getImageUrl() { return imageUrl; }
}
