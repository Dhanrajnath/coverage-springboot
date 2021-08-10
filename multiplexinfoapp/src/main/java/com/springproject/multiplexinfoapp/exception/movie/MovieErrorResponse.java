package com.springproject.multiplexinfoapp.exception.movie;

import lombok.Data;

@Data
public class MovieErrorResponse
{
    private int status;
    private String message;
    private long timeStamp;


    public MovieErrorResponse(){

    }

    public MovieErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
