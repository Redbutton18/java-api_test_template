package com.reqRes.automated.api.models.authorizationModel.response;

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
public class AuthorizationResponseModel {

	@JsonProperty("id")
	private int id;

	@JsonProperty("token")
	private String token;
}