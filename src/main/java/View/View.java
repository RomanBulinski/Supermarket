package View;

import Model.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class View {

    public void printArray( String[] information ){
        for( String element : information){
            System.out.print( element  + " ");
        }
        System.out.println("\n");
    }

    public void printStringList( List<  String > products ){
        for( String  product  : products ){
            System.out.println(product);
        }
    }

    public void printProductList( List<Product> products ){
        for( Product product  : products ){
            printProduct( product );
            System.out.println("\n");
        }
    }

    public void printProduct(  Product product ){
        System.out.print(product.getBarcode() + " ");
        System.out.print(product.getName() + " " );
        System.out.print(product.getAmount() + " " );
        System.out.print(product.getPrice() + " ");
    }
}
