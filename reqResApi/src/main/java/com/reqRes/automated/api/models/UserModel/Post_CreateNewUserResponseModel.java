package com.reqRes.automated.api.models.UserModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Post_CreateNewUserResponseModel {

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private String id;

	@JsonProperty("job")
	private String job;
}