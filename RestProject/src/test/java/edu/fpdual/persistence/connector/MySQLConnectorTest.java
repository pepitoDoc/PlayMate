package edu.fpdual.persistence.connector;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MySQLConnectorTest {

    @InjectMocks
    private MySQLConnector mySQLConnectorInject;

    @Mock
    private Properties propertiesMock;

    @Mock
    private Class<?> driverClassMock;

    @Spy
    private MySQLConstants mySQLConstantsMock;

    @Mock
    private Connection connectionMock;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMySQLConnection_ok() throws ClassNotFoundException, SQLException {

        when(driverClassMock.forName(anyString())).thenReturn(null);
        when(DriverManager.getConnection(anyString())).thenReturn(connectionMock);

        Connection connection = mySQLConnectorInject.getMySQLConnection();

        verify(driverClassMock).forName(anyString());
        verify(DriverManager.getConnection(anyString()));

        assertEquals(connectionMock, connection);

    }

}
