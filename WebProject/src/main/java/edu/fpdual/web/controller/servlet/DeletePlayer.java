package edu.fpdual.web.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fpdual.web.service.PlayerService;
import edu.fpdual.web.service.dto.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="DeletePlayer", urlPatterns = "/delete-player")
public class DeletePlayer extends HttpServlet {
    private PlayerService playerService;

    @Override
    public void init() throws ServletException{
        this.playerService = new PlayerService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try{
            ObjectMapper mapper = new ObjectMapper();

            Player player = mapper.readValue(req.getReader(), Player.class);
            resp.setContentType("text/plain");
            resp.getWriter().write(this.playerService.deletePlayer(player));
        }catch (Exception e){
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
