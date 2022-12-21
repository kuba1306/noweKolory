package com.panienski.nowekolory.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Director")
    private String director;

}

