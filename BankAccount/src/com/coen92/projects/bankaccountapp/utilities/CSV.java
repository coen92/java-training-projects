package com.coen92.projects.bankaccountapp.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    //Method to read data from CSV file and return it as list
    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            while((dataRow = bufferedReader.readLine()) != null) {

                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED..." + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }
}
