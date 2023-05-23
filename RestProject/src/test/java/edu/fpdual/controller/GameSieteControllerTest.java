package edu.fpdual.controller;

import edu.fpdual.api.dto.GameSiete;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.GameSieteManagerImpl;
import edu.fpdual.service.GameSieteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameSieteControllerTest {

    @Mock
    private GameSieteService gameSieteServiceMock;

    @Mock
    private MySQLConnector connectorMock;

    @Mock
    private GameSieteManagerImpl gameSieteManagerImplMock;

    @Mock
    private GameSiete gameSieteMock;

    @Spy
    private GameSieteController gameSieteControllerInject;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertGame_ok() throws SQLException, ClassNotFoundException{

        when(gameSieteServiceMock.insertGame(gameSieteMock)).thenReturn(1);

        Response response = gameSieteControllerInject.insertGame(gameSieteMock);

        MatcherAssert.assertThat(response.getStatus(), Matchers.is(201));

    }

    /*@Mock
    private GameSieteService gameSieteServiceMock;

    @Mock
    private java.sql.Date date;

    @InjectMocks
    private GameSieteController gameSieteControllerMock;

    @Mock
    private GameSiete gameSieteMock;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterGame_ok() throws SQLException, ClassNotFoundException {

        GameSiete expectedGameSiete = GameSiete.builder()
                .player1("Alvaro")
                .player2("Artem")
                .player3("Gisela")
                .dealer("Juan")
                .player1score(5)
                .player2score(4)
                .player3score(8)
                .dealerScore(6.5f)
                .player1bet(2)
                .player2bet(1.33f)
                .player3bet(1)
                .timestamp(date)
                .build();

        Response response = gameSieteControllerMock.insertGame(expectedGameSiete);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testFindByName_ok() throws SQLException, ClassNotFoundException{

        Response response = gameSieteControllerMock.findByName("");
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

    }*/

}
