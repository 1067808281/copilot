package com.citi.copilot.copilotproject.service;

import com.citi.copilot.copilotproject.dto.DataModel;
import org.springframework.stereotype.Service;

import java.io.FileWriter;

@Service
public class CreateHolidayService {
    //create a service class
    public boolean saveDataToCsv(String csvFilePath, DataModel data) {
        //create a try catch block
        try {
            //create a variable to store data
            StringBuilder dataToSave = new StringBuilder();
            //append data
            dataToSave.append(data.getCountryCode()).append(",")
                    .append(data.getCountryDescription()).append(",")
                    .append(data.getHolidayName()).append(",")
                    .append(data.getDate()).append("\n");
            //add try catch block using try-with-resources
            try (FileWriter fileWriter = new FileWriter(csvFilePath, true)) {
                //write data to csv file
                fileWriter.write(dataToSave.toString());
            }
            //return a response
            return true;
        } catch (Exception e) {
            //return a response
            return false;
        }
    }
}
