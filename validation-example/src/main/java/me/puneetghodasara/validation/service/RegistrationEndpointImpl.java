package me.puneetghodasara.validation.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import me.puneetghodasara.boot.exception.CustomException;
import me.puneetghodasara.validation.business.TemperatureService;
import me.puneetghodasara.validation.model.Room;
import me.puneetghodasara.validation.persistence.RoomRepository;
import me.puneetghodasara.validation.validator.Temperature;

/**
 * 
 * @author I324801
 *
 */
@Component("registrationEndpoint")
public class RegistrationEndpointImpl implements RegistrationEndpoint {

	@Resource
	private RoomRepository roomRepository;

	@Resource
	private TemperatureService temperatureService;

	@Override
	public Room registerRoom(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public List<Room> listRooms() {
		return roomRepository.findAll();
	}

	@Override
	public void setTemperature(Integer roomId, Integer temperature) {

		Room room = roomRepository.findOne(Long.valueOf(roomId));
		if (room == null) {
			throw CustomException.getCMSException(Arrays.asList("No Room found with ID" + roomId));
		}

		Temperature tempObj = new Temperature(Double.valueOf(temperature.intValue()));
		temperatureService.setTemperature(room, tempObj);

		return;
	}

}
