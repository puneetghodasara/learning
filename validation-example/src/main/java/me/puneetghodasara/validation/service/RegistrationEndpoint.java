package me.puneetghodasara.validation.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.puneetghodasara.validation.model.Room;

/**
 * This is Jersey endpoints to register room and its equipments
 */
@Path("/room")
public interface RegistrationEndpoint {

	/**
	 * Registers a room based on data provided
	 * 
	 * @param room
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Room registerRoom(Room room);

	/**
	 * List all rooms
	 * 
	 * @param room
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Room> listRooms();

	/**
	 * Sets temperature to a room
	 * 
	 * @param room
	 * @return
	 */
	@POST
	@Path("/{id}/temp/{temp}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Room setTemperature(@PathParam("id") Integer roomId, @PathParam("temp") Integer temperature);
}
