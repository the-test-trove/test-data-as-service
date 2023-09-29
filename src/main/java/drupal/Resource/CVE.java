package drupal.Resource;


import drupal.entity.Solution;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/contentType")
public class CVE {

    @GET
    @Path("/cve")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSolutions()
    {
        return Response.ok().build();
    }

    @GET
    @Path("/cve")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSolution()
    {
        return Response.ok().build();
    }

    @POST
    @Path("/cve")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSolutions(Solution solution)
    {
        return Response.ok().build();
    }

    @PUT
    @Path("/cve/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSolutions(@PathParam("id") Long id, Solution solution)
    {
        return Response.ok().build();
    }


    @DELETE
    @Path("/cve/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSolutions(@PathParam("id") Long id)
    {
        return Response.ok().build();
    }
}
