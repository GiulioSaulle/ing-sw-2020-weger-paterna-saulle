package it.polimi.ingsw.messages.clientMessage;

import it.polimi.ingsw.controller.ClientMessageHandler;
import it.polimi.ingsw.messages.ClientMessage;

public class ConnectionClient implements ClientMessage {
    @Override
    public void Accept(ClientMessageHandler cmh) {cmh.handleMessage(this);}
}
