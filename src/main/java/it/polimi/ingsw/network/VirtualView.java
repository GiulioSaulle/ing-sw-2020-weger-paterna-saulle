package it.polimi.ingsw.network;

import it.polimi.ingsw.Observable;
import it.polimi.ingsw.Observer;
import it.polimi.ingsw.commons.ClientMessage;
import it.polimi.ingsw.commons.ServerMessage;
import it.polimi.ingsw.commons.clientMessages.ConnectionClient;
import it.polimi.ingsw.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class VirtualView extends Observable implements Observer {

    // TODO: the virtual view has to check name params of MESSAGE every time
    private Server server;
    private boolean ended;
    private Map<String, ServerClientHandler> connectedPlayers;

    public VirtualView(Server server){
        this.server = server;
        this.ended = false;
        this.connectedPlayers = new HashMap<>();

        // FIXME remove Controller attribute
        c = new Controller(this);
        addObserver(c);
        //addObserver(new Controller(this));
    }

    // It is used to run some tests about VirtualView and Controller communication
    // FIXME remove
    @Deprecated
    public Controller c;

    protected Map<String, ServerClientHandler> getConnectedPlayers(){
        return connectedPlayers;
    }

    /**
     * this method sends the message to the controller
     * @param message message to send
     */
    protected void notify(ClientMessage message) {
        if(message instanceof ConnectionClient){
            connectedPlayers.put(((ConnectionClient)message).name+((ConnectionClient)message).ip,((ConnectionClient)message).sch);
        }

        // TODO: check for some ClientMessage

        if (!ended) {
            notifyObservers(message);
        }
    }

    @Override
    public void update(Object arg) {
        if( ! (arg instanceof ServerMessage))
            throw new RuntimeException("This must be a ServerMessage object");

        ServerMessage cm = (ServerMessage) arg;
        System.out.println("---> FROM MODEL TO CLI");
        System.out.println("Type: " + cm.toString());

        if(cm.name.equals("")){
            if(server != null)
                server.sendAll(cm,this);
            System.out.println("Receiver: ALL (empty string)");
        }
        else {
            if(server != null)
                server.send(cm,this);
            System.out.println("Receiver: " + cm.name);
        }
        System.out.println("== : == : == : == : == : == : == : ==");
    }

}
