package com.zenika;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Movie(
    String title,
    @JsonProperty("release_date")
    String releaseDate,
    String description
) {

}
