package com.timatooth.cashdrain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Load bank statement CSV files.
 *
 * @author Tim Sullivan <tsullivan@timatooth.com>
 */
public class CSVParser {
    
    public enum BankColumn  {
        //DATE, TYPE, PAYEE, REFERENCE, CODE, AMOUNT
    };

    //public static final Object[] anz = {
    //    BankColumn.AMOUNT
    //};
    
    private ArrayList<ArrayList<String>> data;

    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    public CSVParser(File filename) {
        data = new ArrayList<>();
        read(filename);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<String> row : data) {
            sb.append(row.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    private void read(File filename) {
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                ArrayList<String> row = new ArrayList<>();
                row.addAll(Arrays.asList(line.split(csvSplitBy)));
                data.add(row);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
