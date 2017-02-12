package me.puneetghodasara.validation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Equipment {

	@Id
	@NotNull
	@Range(min = 1, max = 99, message = "Equipment ID must be between 1 and 99")
	@JsonProperty("id")
	public Long id;

	@NotNull
	@NotEmpty
	@JsonProperty("name")
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "Invalid Equipment Name")
	private String name;

}
