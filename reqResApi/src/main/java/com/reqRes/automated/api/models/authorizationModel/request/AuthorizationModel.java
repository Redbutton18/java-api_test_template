package com.reqRes.automated.api.models.authorizationModel.request;

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
public class AuthorizationModel{

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;
}