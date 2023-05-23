package edu.fpdual.controller;


import edu.fpdual.api.dto.GameRaya;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.GameRayaManagerImpl;
import edu.fpdual.service.GameRayaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;


@Path("/gameRaya")
public class GameRayaController {

    private GameRayaService service;

    @POST
    @Path("/insertGame")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertGame(GameRaya gameRaya) throws SQLException, ClassNotFoundException {
        service = new GameRayaService(new MySQLConnector(), new GameRayaManagerImpl());
        int result = service.insertGame(gameRaya);
        if (result > 0) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/findByName")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGameByName(@QueryParam("nickname") String nickname) throws SQLException, ClassNotFoundException {

        service = new GameRayaService(new MySQLConnector(), new GameRayaManagerImpl());
        List<GameRaya> listado = service.findGameByName(nickname);
        return Response.ok().entity(listado).status(Response.Status.CREATED).build();
    }

}
