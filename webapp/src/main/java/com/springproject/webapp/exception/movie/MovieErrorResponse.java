package com.springproject.webapp.exception.movie;

import lombok.Data;

@Data
public class MovieErrorResponse
{
    private String message1;
    private String message2;
    private long timeStamp;


    public MovieErrorResponse(){

    }

    public MovieErrorResponse(String message1, String message2, long timeStamp) {
        this.message1 = message1;
        this.message2 = message2;
        this.timeStamp = timeStamp;
    }
}
