package drupal.Resource;


import drupal.article.ArticleService;
import drupal.requests.CreatedResponse;
import drupal.requests.NotFoundResponse;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.List;

@Path("/v1/contentType")
public class Article {

    @Inject
    ArticleService articleService;

    @GET
    @Path("/articles")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(
        value = {
                @APIResponse(
                    responseCode = "200",
                    description = "Get the list of all articles"
                ),
                @APIResponse(
                        responseCode = "404",
                        description = "No articles are available"
                )
        }
    )

    public Response getArticles()
    {
        NotFoundResponse response = new NotFoundResponse();
       List<drupal.entity.Article> articleList = articleService.getArticles();
       if(!articleList.isEmpty()) {
           return Response.ok(articleList).build();
       }
       else
       {
           response.setContentType("Article");
           response.setMessage("Not found");
           return Response.status(404).entity(response).build();
       }
    }

    @POST
    @Path("/article")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "201",
                            description = "Creates a new Article"
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Bad Request"
                    )
            }
    )
    public Response saveArticle(drupal.entity.Article article)
    {
      CreatedResponse response =  articleService.SaveArticle(article);
      if(response.getId()>=1)
      {
          return Response.status(201).entity(response).build();
      }
      else {
          return Response.status(Response.Status.BAD_REQUEST).build();
      }

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/article")
    public Response getArticle()
    {
        NotFoundResponse response = new NotFoundResponse();
        drupal.entity.Article article = articleService.getArticle();
        if(article.id>=1)
        {
            return Response.ok(article).build();
        }
        else
        {
            response.setContentType("Article");
            response.setMessage("Not found");
            return Response.status(404).entity(response).build();
        }
    }

    @PUT
    @Path("article/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateArticle(@PathParam("id") Long id, drupal.entity.Article articleUpdate) {
          boolean status = articleService.updateArticle(id, articleUpdate);
          NotFoundResponse response = new NotFoundResponse();
            if (status) {
                response.setContentType("Article");
                response.setId(id);
                response.setMessage("The Article is Updated with ");
                return Response.status(200).entity(response).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Get the list of all articles"
                    ),
                    @APIResponse(
                            responseCode = "404",
                            description = "No articles are available"
                    )
            }
    )
    public Response deleteArticle(@PathParam("id") Long id)
    {
        boolean status = articleService.deleteArticle(id);
        NotFoundResponse response = new NotFoundResponse();
        response.setId(id);
        if(status)
        {
            response.setMessage("Deleted Successfully");
            response.setContentType("Article");
            return Response.status(200).entity(response).build();
        }
        else {
            response.setMessage("Not Found" );
            response.setContentType("Article");
            return Response.status(404).entity(response).build();
        }
    }


}
