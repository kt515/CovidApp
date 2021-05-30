package com.example.demo;

import java.sql.Date;

public class HealthStaffEditCertForm {
    private Date date;
    private String time;
    private String vaccine_location;

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getVaccine_location(){
        return vaccine_location;
    }

    public void setVaccine_location(String vaccine_location){
        this.vaccine_location = vaccine_location;
    }
}
