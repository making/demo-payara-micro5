package com.example;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HelloEndpoint {
    @Inject
    CalcService calcService;

    @GET
    public String hi() {
        return "Hello World!";
    }

    @GET
    @Path("add")
    @Produces(MediaType.TEXT_PLAIN)
    public int add(@QueryParam("a") @DefaultValue("0") int a, @QueryParam("b") @DefaultValue("0") int b) {
        return calcService.add(a, b);
    }
}
