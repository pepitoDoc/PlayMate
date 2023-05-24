package edu.fpdual.web.service.client;

import edu.fpdual.web.service.dto.GameSiete;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameSieteClientTest {

    @InjectMocks
    private GameSieteClient gameSieteClientInject;

    @Mock
    private WebTarget webTargetMock;

    @Mock
    private Client clientMock;

    @Mock
    private Invocation invocationMock;

    @Mock
    private Invocation.Builder builderMock;

    @Mock
    private Response responseMock;

    @Mock
    private GameSiete gameSieteMock;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertGame_ok() {

        when(clientMock.target(anyString())).thenReturn(webTargetMock);
        when(webTargetMock.request()).thenReturn(builderMock);
        when(builderMock.accept(ArgumentMatchers.any(MediaType.class))).thenReturn(builderMock);
        when(builderMock.buildPost(ArgumentMatchers.any(Entity.class))).thenReturn(invocationMock);
        when(invocationMock.invoke(Response.class)).thenReturn(responseMock);

        Response actualResponse = this.gameSieteClientInject.insertGame(gameSieteMock);

    }

}
