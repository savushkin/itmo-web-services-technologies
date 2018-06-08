package me.savushkin.wst.lab6;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WSTExceptionMapper implements ExceptionMapper<WSTException> {
    @Override
    public Response toResponse(WSTException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

    }
}
