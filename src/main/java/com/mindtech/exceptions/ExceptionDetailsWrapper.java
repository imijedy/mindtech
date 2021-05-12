package com.mindtech.exceptions;

import java.util.Date;

public class ExceptionDetailsWrapper {
    /*Adattagok*/
    private String message;
    private String details;
    private Date time;

    /*Konstruktor*/

    public ExceptionDetailsWrapper(String message, String details, Date time) {
        this.message = message;
        this.details = details;
        this.time = time;
    }

    /*Getterek, Setterek*/

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
}
