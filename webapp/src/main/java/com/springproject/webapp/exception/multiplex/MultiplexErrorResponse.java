package com.springproject.webapp.exception.multiplex;

import lombok.Data;

@Data
public class MultiplexErrorResponse
{
    private int status;
    private String message;
    private long timeStamp;


    public MultiplexErrorResponse(){

    }

    public MultiplexErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
