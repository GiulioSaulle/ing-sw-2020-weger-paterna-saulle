package it.polimi.ingsw.network;

import it.polimi.ingsw.commons.clientMessages.ConnectionClient;
import org.junit.Test;


import static org.junit.Assert.*;

public class ServerTest {

    Server CG13 = new Server (1234);

    /**
     * QuickStart Server ---> ControllerTest Allows Parallel Exectuions
     */
    @Test
    public void runServer() /*throws IOException*/{
        //CG13.startServer();
    }

    @Test
    public void addPlayerTest(){
        // FIXME
        //VirtualView vv = new VirtualView(CG13);
        //CG13.setCurrentVirtualView(vv);
        //CG13.addPlayer(new ConnectionClient("Giorgio"));
        //assertTrue(CG13.isInWaitingRoom("Giorgio"));
    }

    @Test
    public void sendTest() {
      //  CG13.addPlayer(new ConnectionClient("Marco"));
        //CG13.addPlayer(new ConnectionClient("Francesco"));
        //G13.setCurrentVirtualView(CG13.getVirtualViews().get(0));
       // CG13.send(new OpponentConnection("Marco"), CG13.getVirtualViews().get(1));
    }



    @Test
    public void main() {
    }
}