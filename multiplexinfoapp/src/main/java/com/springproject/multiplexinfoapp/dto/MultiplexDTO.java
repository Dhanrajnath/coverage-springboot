package com.springproject.multiplexinfoapp.dto;

import com.springproject.multiplexinfoapp.entity.Movie;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class MultiplexDTO {

    private int idMultiplex;

    @NotNull
    @Size(min = 1, message = "required")
    private String multiplexName;

    @NotNull
    @Min(value = 1,message = "minimum is 1")
    @Max(value=5,message="maximum is 5")
    private float multiplexRating;

    @NotNull(message = "required")
    @Size(min=1,message = "required")
    private String multiplexLocation;

    @ToString.Exclude
    private List<Movie> movieList ;

}
