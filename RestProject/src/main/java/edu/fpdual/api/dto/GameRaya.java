package edu.fpdual.api.dto;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class GameRaya {
    private String player1;
    private String player2;
    private String winner;
    private String date;

    public GameRaya(ResultSet resultSet) {
        try {
            this.player1 = resultSet.getString(("player1"));
            this.player2 = resultSet.getString(("player2"));
            this.winner = resultSet.getString(("winner"));
            this.date = resultSet.getString(("date"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
