package com.tecsus.ddc.controller;

import com.tecsus.ddc.controller.connector.Connector;
import org.junit.Test;

/**
 * @author TOBIASDASILVALINO
 */
public class ConnectionTest {

    @Test
    public void justConnectingTest() {
        Connector con = new Connector().connect();

        con.close();
    }
}
