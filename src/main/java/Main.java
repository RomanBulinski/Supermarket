import Bill_Controler.Bill;
import DAO.CSVreader;
import DAO.Products;
import DAO.TXTreader;
import Model.Product;
import View.View;

import java.util.List;
import java.util.Map;

public class Main {

    private static List<String> getProductInBasket() {
        String pathtxtFile = "/home/roman/codecool/40_Advanced/01_TW/03_Supermarket/src/main/java/source/bill.txt";
        TXTreader txTreader = new TXTreader();
        return txTreader.txtreader( pathtxtFile );
    }

    private static List<Product> getProducts(Products products) {
        String pathcsvFile = "/home/roman/codecool/40_Advanced/01_TW/03_Supermarket/src/main/java/source/info.csv";
        String line = "";
        String cvsSplitBy = ",";
        CSVreader csVreader = new CSVreader();
        List<String> productinformation = csVreader.csvreader( pathcsvFile , cvsSplitBy);
        return products.getproductList( productinformation );
    }



    public static void main(String[] args) {

        Bill bill = new Bill();
        Products products = new Products();

        List<Product> productsList = getProducts(products);
        List<String> barcodes = getProductInBasket();

        Double billpayment = bill.countBill( barcodes, productsList   );
        System.out.println(billpayment);


    }

}
