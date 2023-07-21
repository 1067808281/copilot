package com.citi.copilot.copilotproject.service;

import com.citi.copilot.copilotproject.dto.DataModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UpdateHolidayServiceTest {
    @Autowired
    UpdateHolidayService service;

    @Test
    void updateDataToCsv() throws FileNotFoundException {
        String path = "src/test/resources/holiday.csv";
        List<DataModel> dataModels = new ArrayList<>();
        DataModel data1 = new DataModel();
        data1.setCountryCode("SG");
        data1.setCountryDescription("Singapore");
        data1.setDate("2021-01-01");
        data1.setHolidayName("New Year's Day-edit");
        dataModels.add(data1);
        Assertions.assertTrue(service.updateDataToCsv(path,dataModels));
    }
}