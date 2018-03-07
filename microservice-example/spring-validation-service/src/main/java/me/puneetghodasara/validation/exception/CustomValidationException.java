package me.puneetghodasara.validation.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.puneetghodasara.boot.exception.CustomException;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.stream.Collectors;

@Provider
public class CustomValidationException implements ExceptionMapper<ConstraintViolationException> {

    private static final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .create();

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        List<String> message = exception.getConstraintViolations()
                .stream()
                .map(cv -> /*
                 * cv.getPropertyPath() .toString() +
                 */ cv.getMessage())
                .collect(Collectors.toList());

        CustomException convertedException = CustomException.getCMSException(message);

        return Response.status(convertedException.getResponse()
                .getStatus())
                .type(MediaType.APPLICATION_JSON)
                .entity(gson.toJson(convertedException))
                .build();

    }

}
