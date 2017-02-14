package me.puneetghodasara.student.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import me.puneetghodasara.student.model.Student;

@Path("/student")
public interface StudentEndpoint {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student registerStudent(Student room);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> listStudents();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student listStudent(@PathParam("id") Long id);

	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public Student listStudent(@QueryParam("name") String name);

}
