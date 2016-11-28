package me.puneetghodasara.validation.exception;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Provider
public class CustomException extends WebApplicationException implements ExceptionMapper<RuntimeException> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2274013713207831480L;

	@Expose
	@SerializedName("PROBLEMS")
	private List<String> message;

	@Expose
	@SerializedName("EXCEPTION")
	private String exception;

	private static final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls()
			.create();

	public CustomException() {
	}

	private CustomException(Status status) {
		super(status);
	}

	@Override
	public Response toResponse(RuntimeException exception) {
		if (exception instanceof CustomException) {
			return Response.status(((CustomException) exception).getResponse()
					.getStatus())
					.type(MediaType.APPLICATION_JSON)
					.entity(gson.toJson(exception))
					.build();
		}

		exception.printStackTrace();

		CustomException convertedException = new CustomException(Status.INTERNAL_SERVER_ERROR);
		Response build = Response.status(convertedException.getResponse()
				.getStatus())
				.type(MediaType.APPLICATION_JSON)
				.entity(gson.toJson(convertedException))
				.build();
		return build;
	}

	public static CustomException getCMSException(List<String> problems) {
		CustomException convertedException = new CustomException(Status.INTERNAL_SERVER_ERROR);
		convertedException.exception = "Validation Exception";
		convertedException.message = problems;
		return convertedException;
	}

}
