package com.citi.copilot.copilotproject.controller;

import com.citi.copilot.copilotproject.dto.DataModel;
import com.citi.copilot.copilotproject.service.CreateHolidayService;
import com.citi.copilot.copilotproject.service.UpdateHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/holiday")
public class holidayController {
    //create a constant variable
    private static final String CSV_FILE_PATH = "./holiday.csv";

    @Autowired
    private CreateHolidayService createHolidayService;

    @Autowired
    private UpdateHolidayService updateHolidayService;

    @PostMapping("/save")
    public ResponseEntity<String> savaDataToCsv(@RequestBody List<DataModel> dataList) {
        //create try catch block
        try {
            //call the saveDataToCsv method
            for (DataModel data: dataList
                 ) {
                createHolidayService.saveDataToCsv(CSV_FILE_PATH, data);
            }
            //return a response
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            //return a response
            return ResponseEntity.badRequest().body("Error while saving data to CSV");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateDataToCsv(@RequestBody List<DataModel> dataList) {


        //create try catch block
        try {
            updateHolidayService.updateDataToCsv(CSV_FILE_PATH, dataList);
            //return a response
            return ResponseEntity.ok("Data updated successfully");
        } catch (Exception e) {
            //return a response
            return ResponseEntity.badRequest().body("Error while updating data to CSV");
        }
    }

    @PostMapping("/delete")
    public ResponseEntity  deleteDataToCsv(@RequestBody List<DataModel> dataList) {
        //create try catch block
        try {

            //return a response
            return ResponseEntity.ok("Data deleted successfully");
        } catch (Exception e) {
            //return a response
            return ResponseEntity.badRequest().body("Error while deleting data to CSV");
        }
    }
}
