package drupal.Resource;


import drupal.entity.Solution;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/contentType")
public class Solutions {

    @GET
    @Path("/solutions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSolutions()
    {
        return Response.ok().build();
    }

    @GET
    @Path("/solution")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSolution()
    {
        return Response.ok().build();
    }

    @POST
    @Path("/solution")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSolutions(Solution solution)
    {
        return Response.ok().build();
    }

    @PUT
    @Path("/solution/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSolutions(@PathParam("id") Long id, Solution solution)
    {
        return Response.ok().build();
    }


    @DELETE
    @Path("/solution/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSolutions(@PathParam("id") Long id)
    {
        return Response.ok().build();
    }
}
