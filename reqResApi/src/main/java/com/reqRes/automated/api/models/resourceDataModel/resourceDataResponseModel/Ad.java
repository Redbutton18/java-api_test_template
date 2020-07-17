package com.reqRes.automated.api.models.resourceDataModel.resourceDataResponseModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ad{

    @JsonProperty("company")
    private String company;

    @JsonProperty("text")
    private String text;

    @JsonProperty("url")
    private String url;
}