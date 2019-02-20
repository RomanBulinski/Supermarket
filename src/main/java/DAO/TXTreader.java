package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TXTreader {

    public List< String > txtreader (String pathtxtFile ){
        String line = "";
        List< String > resuls = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader( pathtxtFile ))) {
            while ((line = br.readLine()) != null) {
                resuls.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resuls;
    }


}


