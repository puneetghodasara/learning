package me.puneetghodasara.student.service;

import me.puneetghodasara.student.model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
