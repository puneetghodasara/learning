package me.puneetghodasara.validation.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import me.puneetghodasara.validation.model.Room;
import me.puneetghodasara.validation.validator.Temperature;
import me.puneetghodasara.validation.validator.ValidTemperature;

/**
 * This is special service markes with @Validated to make sure all methods would
 * be validated
 * 
 * @author I324801
 *
 */
@Validated
public interface TemperatureService {

	/**
	 * 
	 * @param room
	 * @param t
	 * @return
	 */
	boolean setTemperature(@NotNull(message = "Can not set temperature on null room") Room room,
			@ValidTemperature Temperature t);

}
