package edu.fpdual.persistence.manager.impl;

import edu.fpdual.api.dto.GameRaya;
import edu.fpdual.persistence.manager.GameRayaManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameRayaManagerImpl implements GameRayaManager {


    public int insert(Connection con, GameRaya gameRaya) {

        String sql = "INSERT INTO gameraya(player1, player2, winner, date) values (?, ?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, gameRaya.getPlayer1());
            statement.setString(2, gameRaya.getPlayer2());
            statement.setString(3, gameRaya.getWinner());
            statement.setString(4, gameRaya.getDate());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    public List<GameRaya> findByName(Connection con, String name) {
        String sql = "SELECT * FROM gameraya WHERE " +
                "player1 LIKE ? OR " +
                "player2 LIKE ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, "%" + name + "%");
            statement.setString(2, "%" + name + "%");

            ResultSet result = statement.executeQuery();
            List<GameRaya> gameRayas = new ArrayList<>();
            while (result.next()) {
                gameRayas.add(new GameRaya(result));
            }
            return gameRayas;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
