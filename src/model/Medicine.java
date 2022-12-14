package model;

public class Medicine {
    private int id;
    private String name;
    private double price;
    private boolean isExist;

    public Medicine(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Medicine(String name) {
        this.name = name;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isExist=" + isExist +
                '}';
    }
}
