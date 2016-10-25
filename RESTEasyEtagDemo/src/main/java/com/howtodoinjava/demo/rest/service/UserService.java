package com.howtodoinjava.demo.rest.service;
 
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import com.howtodoinjava.demo.rest.data.UserDatabase;
 
@Path("/user-service")
public class UserService
{
	@PermitAll
    @GET
    @Path("/users/{id}")
	@Produces("application/xml")
    public Response getUserById(@PathParam("id") int id, @Context Request req)
    {
        Response.ResponseBuilder rb = Response.ok(UserDatabase.getUserById(id));
        return rb.build();
    }
     
	@RolesAllowed("GUEST")
    @PUT
    @Path("/users/{id}")
	@Consumes("application/xml")
	@Produces("application/xml")
    public Response updateUserById(@PathParam("id") int id)
    {
        //Update the User resource
        UserDatabase.updateUser(id);
        return Response.status(200).build();
    }
}