package me.puneetghodasara.validation.business;

import org.springframework.stereotype.Component;

import me.puneetghodasara.validation.model.Room;
import me.puneetghodasara.validation.validator.Temperature;

/**
 * Handler to operate on Temperature related things
 * 
 * @author I324801
 *
 */
@Component("temperatureService")
public class TemperatureServiceImpl implements TemperatureService {

	/**
	 * Will kick off temperature control unit to set temperature of @param room
	 * to @param t
	 * 
	 * @return
	 */
	@Override
	public boolean setTemperature(Room room, Temperature t) {
		/*
		 * None of the parameters will be null, feel free to use any of the
		 * properties of any parameters.
		 */
		// System.out.println("Setting Temperature of " + room.getName() + " to
		// " + t);
		room.setTemperature(t);
		return true;
	}
}
