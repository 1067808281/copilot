package com.citi.copilot.copilotproject.service;

import com.citi.copilot.copilotproject.dto.DataModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreateHolidayServiceTest {
    @Autowired
    private CreateHolidayService service;

    @Test
    void saveDataToCsv() {
        String path = "src/test/resources/holiday.csv";
        DataModel data = new DataModel();
        data.setCountryCode("SG");
        data.setCountryDescription("Singapore");
        data.setDate("2021-01-01");
        data.setHolidayName("New Year's Day");
        Assertions.assertTrue(service.saveDataToCsv(path,data));
    }
}