package Model;


import java.util.HashMap;
import java.util.Map;

public class Product {

    private String barcode;
    private String name;
    private int amount;
    private double price;
    private Map< Integer, Double> amountAndPrice = new HashMap<>();

    public Product(String barcode, String name, int amount, double price ){
        this.barcode = barcode;
        this.name = name;
        this.amount = amount;
        this.price = price;
        amountAndPrice.put(amount,price);
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<Integer, Double> getAmountAndPrice() {
        return amountAndPrice;
    }

    public void setAmountAndPrice(Map<Integer, Double> amountAndPrice) {
        this.amountAndPrice = amountAndPrice;
    }
}



