package it.polimi.ingsw.messages.clientMessages;

import it.polimi.ingsw.controller.ClientMessageHandler;
import it.polimi.ingsw.messages.ClientMessage;

public class Ping  implements ClientMessage {
    @Override
    public void Accept(ClientMessageHandler cmh) {cmh.handleMessage(this);}
}