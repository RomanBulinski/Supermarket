package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVreader {


    public List< String > csvreader ( String pathcsvFile, String cvsSplitBy ){
        String line = "";
        List< String > resuls = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader( pathcsvFile ))) {
            while ((line = br.readLine()) != null) {
                String temp = "";
                String[] pruduct = line.split(cvsSplitBy);
                for ( String info : pruduct){
                    temp = temp + info + " ";
                }
                resuls.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resuls;
    }


}
