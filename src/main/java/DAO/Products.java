package DAO;

import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class Products {

        public List<Product>  getproductList(List<String> stringList ){
        Product product;

        List <  String >  listOfBarcodes = new ArrayList<>();
        List <  Product >  tempList = new ArrayList<>();
        for ( int i =1; i<stringList.size(); i++) {

            String[] productinfo = stringList.get(i).split("  ");

            if (tempList.size() ==0) {
                product = new Product(productinfo[0].trim(), productinfo[1].trim(), Integer.valueOf(productinfo[2].trim()), Double.valueOf(productinfo[3].trim()));
                tempList.add(product);
                listOfBarcodes.add(productinfo[0].trim());
            }
            if (tempList.size()!=0){
                if (  listOfBarcodes.contains(productinfo[0].trim())){
                    for ( Product  item :tempList) {
                        if( item.getBarcode().equals( productinfo[0].trim())){
                            item.getAmountAndPrice().put( Integer.valueOf(productinfo[2].trim()), Double.valueOf(productinfo[3].trim()) );
                        }
                    }
                }else {
                    product = new Product(productinfo[0].trim(), productinfo[1].trim(), Integer.valueOf(productinfo[2].trim()), Double.valueOf(productinfo[3].trim()));
                    tempList.add(product);
                    listOfBarcodes.add(productinfo[0].trim());
                }
            }
        }
        return tempList;
    }

}
