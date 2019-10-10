package com.reqRes.automated.api.models.UserModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import static com.reqRes.automated.api.utilits.dataGenerator.UserDataGenerator.getFakerFirstName;
import static com.reqRes.automated.api.utilits.dataGenerator.UserDataGenerator.getFakerJob;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post_CreateNewUserModel {

	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;

	public Post_CreateNewUserModel randomize() {
		this.name = getFakerFirstName();
		this.job = getFakerJob();

		return this;
	}
}

