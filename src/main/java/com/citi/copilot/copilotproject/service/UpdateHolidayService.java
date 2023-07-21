package com.citi.copilot.copilotproject.service;

import com.citi.copilot.copilotproject.dto.DataModel;
import com.citi.copilot.copilotproject.util.ReadCsvFileUtil;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UpdateHolidayService {
    public boolean updateDataToCsv(String path, List<DataModel> dataList) throws FileNotFoundException {
        //date+country to avoid duplicate
        Map<String,DataModel> dataMap = ReadCsvFileUtil.readCsv(path);
        //iterate through dataList
        for (DataModel data: dataList
             ) {
            //check if the data is present in the map
            if(dataMap.containsKey(data.getCountryCode()+data.getDate())){
                //if present, update the data
                dataMap.put(data.getCountryCode()+data.getDate(),data);
            }
        }
        //write the data in map to csv file
        //create try catch block
        try (FileWriter fileWriter = new FileWriter(path)) {
            //write data to csv file
            for (DataModel data: dataMap.values()
                 ) {
                fileWriter.write(data.getCountryCode()+","+data.getCountryDescription()+","+data.getHolidayName()+","+data.getDate()+"\n");
            }
        } catch (Exception e) {
            //return a response
        }
        return true;
    }
}
