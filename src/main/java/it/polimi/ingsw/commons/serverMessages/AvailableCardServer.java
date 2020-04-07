package it.polimi.ingsw.commons.serverMessages;

import it.polimi.ingsw.commons.ServerMessage;
import it.polimi.ingsw.model.cards.CardName;
import it.polimi.ingsw.view.ViewInterface;

import java.io.Serializable;
import java.util.ArrayList;

public class AvailableCardServer extends ServerMessage implements Serializable {
    @Override
    public void Accept(ViewInterface smh) {smh.handleMessage(this);}

    public ArrayList<CardName> cardName;

    public AvailableCardServer(ArrayList<CardName> cardName){
        this.name="";
        this.cardName=cardName;
    }
}