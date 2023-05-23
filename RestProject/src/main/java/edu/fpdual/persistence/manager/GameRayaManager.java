package edu.fpdual.persistence.manager;

import edu.fpdual.api.dto.GameRaya;

import java.sql.Connection;

public interface GameRayaManager extends Manager<GameRaya> {

    int insert(Connection con, GameRaya gameRaya);

}
