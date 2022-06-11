package parsing;

import java.util.Objects;

public class Product {
    private int code;
    private String name;
    private double price;
    private String manufacturer;
    private String color;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColor() {
        return color;
    }

    public Product() {
    }

    public Product(int code, String name, double price, String manufacturer, String color) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
         Product other = (Product) obj;
         return code == other.code && name.equals(other.name) && price == other.price &&
                 manufacturer.equals(other.manufacturer) && color.equals(other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, price, manufacturer, color);
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
