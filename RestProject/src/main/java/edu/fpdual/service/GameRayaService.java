package edu.fpdual.service;

import edu.fpdual.api.dto.GameRaya;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.GameRayaManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GameRayaService {

    private MySQLConnector connector;
    private GameRayaManagerImpl manager;

    public GameRayaService(MySQLConnector con, GameRayaManagerImpl manager) {
        this.connector = con;
        this.manager = manager;
    }

    public int insertGame(GameRaya game4Raya) throws SQLException, ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.insert(con, game4Raya);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List<GameRaya> findGameByName(String nickname) throws SQLException, ClassNotFoundException {

        Connection con = null;
        try {
            con = connector.getMySQLConnection();
            return manager.findByName(con, nickname);
        } finally {
            if (con!=null) {
                con.close();
            }
        }
    }

}
