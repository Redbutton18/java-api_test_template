package com.reqRes.automated.api.models.userDataModel.listUsersDataResponseModel;

import java.util.List;

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
public class ListUserDataResponseModel {

    @JsonProperty("per_page")
    private Integer perPage;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("ad")
    private Ad ad;

    @JsonProperty("data")
    private List<DataItem> data;

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("total_pages")
    private Integer totalPages;
}