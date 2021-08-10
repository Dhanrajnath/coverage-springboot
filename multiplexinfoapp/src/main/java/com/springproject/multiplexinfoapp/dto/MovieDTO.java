package com.springproject.multiplexinfoapp.dto;


import com.springproject.multiplexinfoapp.entity.Multiplex;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class MovieDTO {

        private int idMovie;

        @NotNull
        @Size(min=1,message = "required")
        private String movieTitle;

        @NotNull
        @Size(min=1,message = "required")
        private String movieType;

        @NotNull
        @Min(value = 1,message = "minimum is 1")
        @Max(value=5,message="maximum is 5")
        private float movieRating;

        @ToString.Exclude
        private List<Multiplex> multiplexList;


}
