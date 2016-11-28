package me.puneetghodasara.validation.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import me.puneetghodasara.validation.business.TemperatureService;
import me.puneetghodasara.validation.business.ValidatorService;
import me.puneetghodasara.validation.exception.CustomException;
import me.puneetghodasara.validation.model.Room;
import me.puneetghodasara.validation.model.Temperature;
import me.puneetghodasara.validation.persistence.RoomRepository;

/**
 * 
 * @author I324801
 *
 */
@Component("registrationEndpoint")
public class RegistrationEndpointImpl implements RegistrationEndpoint {

	@Resource
	private ValidatorService validatorService;

	@Resource
	private RoomRepository roomRepository;

	@Resource
	private TemperatureService temperatureService;

	@Override
	public Room registerRoom(Room room) {
		List<String> problems = validatorService.validate(room);
		if (problems != null && !problems.isEmpty()) {
			throw CustomException.getCMSException(problems);
		}

		roomRepository.save(room);

		return room;
	}

	@Override
	public List<Room> listRooms() {
		return roomRepository.findAll();
	}

	@Override
	public Room setTemperature(Integer roomId, Integer temperature) {

		Room room = roomRepository.findOne(Long.valueOf(roomId));
		if (room == null) {
			throw CustomException.getCMSException(Arrays.asList("No Room found with ID" + roomId));
		}

		Temperature tempObj = new Temperature(Double.valueOf(temperature.intValue()));
		temperatureService.setTemperature(room, tempObj);
		return null;
	}

}
