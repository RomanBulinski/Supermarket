import Bill_Controler.Bill;
import DAO.CSVreader;
import DAO.Products;
import Model.Product;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBillClassSimpleVersion {

    Products products = new Products();
    Bill bill = new Bill();
    List<Product> productsList = getProducts(products);

    private static List<Product> getProducts(Products products) {
        String pathcsvFile = "/home/roman/codecool/40_Advanced/01_TW/03_Supermarket/src/main/java/source/info.csv";
        String line = "";
        String cvsSplitBy = ",";
        CSVreader csVreader = new CSVreader();
        List<String> productinformation = csVreader.csvreader( pathcsvFile, cvsSplitBy );
        return products.getproductList( productinformation );
    }


    @Test
    public void testCountBill_1beer(){
        List< String > barcodes = Arrays.asList("1001");
        assertEquals(   1.20 , bill.countBillsimpleVersion( barcodes, productsList ));
    }

    @Test
    public void testCountBill_2beer(){
        List< String > barcodes = Arrays.asList("1001", "1001");
        assertEquals(   2.00 , bill.countBillsimpleVersion( barcodes, productsList ));
    }

    @Test
    public void testCountBill_4beer(){
        List< String > barcodes = Arrays.asList("1001", "1001","1001", "1001");
        assertEquals(   4.00 , bill.countBillsimpleVersion( barcodes, productsList ));
    }

    @Test
    public void testCountBill_3beer(){
        List< String > barcodes = Arrays.asList("1001","1001","1001");
        assertEquals(   3.20 , bill.countBillsimpleVersion( barcodes, productsList ));
    }

    @Test
    public void testCountBill_1choclate(){
        List< String > barcodes = Arrays.asList("3401");
        assertEquals(   3.15 , bill.countBillsimpleVersion( barcodes, productsList ));
    }

    @Test
    public void testCountBill_2choclate(){
        List< String > barcodes = Arrays.asList("3401", "3401");
        assertEquals(   6.30 , bill.countBillsimpleVersion( barcodes, productsList ));
    }


    @Test
    public void testCountBill_1_egg(){
        List< String > barcodes = Arrays.asList("1243");
        assertEquals(   0.20 , bill.countBillsimpleVersion( barcodes, productsList ));
    }

    @Test
    public void testCountBill_2_egg(){
        List< String > barcodes = Arrays.asList("1243","1243");
        assertEquals(   0.40 , bill.countBillsimpleVersion( barcodes, productsList ));
    }

    @Test
    public void testCountBill_10_egg(){
        List< String > barcodes = Arrays.asList("1243","1243","1243","1243","1243","1243","1243","1243","1243","1243");
        assertEquals(   1.90 , bill.countBillsimpleVersion( barcodes, productsList ));
    }

    @Test
    public void testCountBill_2_egg_2_choclet(){
        List< String > barcodes = Arrays.asList("1243","1243","3401", "3401");
        assertEquals(   6.70 , bill.countBillsimpleVersion( barcodes, productsList ));
    }





}
