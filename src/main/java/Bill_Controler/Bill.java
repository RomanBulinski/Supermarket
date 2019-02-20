package Bill_Controler;

import Model.Product;

import java.math.BigDecimal;
import java.util.*;

public class Bill {


    private Map< String,Integer > amountOfProducts ( List< String > barcodes ){
        Map< String,Integer > temlist = new HashMap<>();
        for( String barcode : barcodes ){
            if( !temlist.containsKey(barcode) ){
                temlist.put(barcode, 0);
            }
            if( temlist.containsKey(barcode) ){
                 temlist.replace( barcode, temlist.get(barcode)+1 );
            }
        }
        return temlist;
    }

    public double countBillsimpleVersion(List< String > barcodes, List< Product> productList ){
        double bill = 0.0;
        int beerCount =0;
        int egssCout =0;

        for( int i=0; i<barcodes.size(); i++){
            for( int j=0; j<productList.size(); j++  ){
                if ( barcodes.get(i).equals( productList.get(j).getBarcode() ) ){

                    bill = bill + productList.get(j).getPrice() ;

                    if(barcodes.get(i).equals("1001")  ){
                        ++beerCount;
                        if(beerCount == 2){
                            bill = bill - 0.4;
                            beerCount=0;
                        }
                    }

                    if(barcodes.get(i).equals("1243")  ){
                        ++egssCout;
                        if(egssCout == 10){
                            bill = bill - 0.1;
                            egssCout=0;
                        }
                    }
                }
            }
        }
        bill=new BigDecimal(bill).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return bill;
    }

    public double countBill ( List< String > barcodes, List< Product> availableProducts ){

        double bill = 0.0;

        Map< String,Integer > sumOfProducts  = amountOfProducts( barcodes );

        for ( int i =0; i < availableProducts.size(); i++){

            Product product = availableProducts.get( i );
            String tempBarcodeOfProduct = availableProducts.get(i).getBarcode();

            if(  sumOfProducts.get( tempBarcodeOfProduct ) != null  ) {

                int amountOfthisProducts = sumOfProducts.get(tempBarcodeOfProduct);

                Map<Integer, Double> amountANDprice = product.getAmountAndPrice();
                Set<Integer> amount = amountANDprice.keySet();
                Set<Integer> amountDESC = new TreeSet<>(amount);

                List<Integer> tempAmounts = new ArrayList<>();
                Iterator iteratorOveramountDESC = amountDESC.iterator();
                while (iteratorOveramountDESC.hasNext()) {
                    Integer tem = (Integer) iteratorOveramountDESC.next();
                    tempAmounts.add(tem);
                }
                Collections.reverse(tempAmounts);

                for (int k = 0; k < tempAmounts.size(); k++) {
                    while(amountOfthisProducts >= tempAmounts.get(k)) {
                        amountOfthisProducts = amountOfthisProducts - tempAmounts.get(k);
                        double tempPrice = amountANDprice.get(tempAmounts.get(k));
                        bill = bill + tempPrice;
                    }
                }
            }
        }
        return bill;
    }



}


