package com.citi.copilot.copilotproject.util;

import com.citi.copilot.copilotproject.dto.DataModel;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadCsvFileUtil {
    public static Map<String, DataModel> readCsv(String path) throws FileNotFoundException {
        //date+country to avoid duplicate
        Map<String, DataModel> dataMap = new HashMap<>();
        //read each line from csv file using buffered reader
        Reader fileReader = new FileReader(path);
        //create a try catch block
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            //create a variable to store data
            String line;
            //read the data
            while ((line = bufferedReader.readLine()) != null) {
                //split the data
                String[] data = line.split(",");
                //check if the data is equal to the data passed
                dataMap.put(data[0]+data[3],new DataModel(data[0],data[1],data[2],data[3]));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return dataMap;
    }
}
