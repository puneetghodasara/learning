package me.puneetghodasara.validation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import me.puneetghodasara.validation.validator.AllUnique;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Room {

	@Id
	@NotNull
	@Range(min = 1, max = 99, message = "Room ID must be between 1 and 99")
	@JsonProperty("id")
	public Long roomId;

	@NotNull
	@Length(min = 0, max = 16, message = "Unique Name length is invalid")
	@JsonProperty("unique")
	@Pattern(regexp = "[A-Za-z0-9_]*", message = "Invalid Unique ID")
	private String uniqueName;

	@NotNull
	@NotEmpty
	@JsonProperty("name")
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "Invalid Name")
	private String name;

	@Past
	@NotNull
	@JsonProperty("register")
	private Date registerDate;

	@Valid
	@AllUnique(value = "id")
	@Size(max = 3)
	@JsonProperty("equipments")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Equipment> equipments;

	public String getName() {
		return name;
	}

}
