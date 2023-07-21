package com.citi.copilot.copilotproject.dto;

public class DataModel {
    //create variables country code,country description,holiday name and date
    private String countryCode;
    private String countryDescription;
    private String holidayName;
    private String date;

    public DataModel() {
    }

    public DataModel(String datum, String datum1, String datum2, String datum3) {
        this.countryCode = datum;
        this.countryDescription = datum1;
        this.holidayName = datum2;
        this.date = datum3;
    }


    //create getters and setters
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String country) {
        this.countryCode = country;
    }

    public String getCountryDescription() {
        return countryDescription;
    }

    public void setCountryDescription(String countryDescription) {
        this.countryDescription = countryDescription;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holiday) {
        this.holidayName = holiday;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
