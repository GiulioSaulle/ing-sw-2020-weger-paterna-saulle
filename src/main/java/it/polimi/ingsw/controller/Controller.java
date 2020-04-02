package it.polimi.ingsw.controller;

import it.polimi.ingsw.Observer;
import it.polimi.ingsw.commons.ClientMessage;
import it.polimi.ingsw.commons.clientMessages.*;
import it.polimi.ingsw.model.Match;
import it.polimi.ingsw.model.Status;
import it.polimi.ingsw.view.server.VirtualView;

public class Controller implements Observer, ClientMessageHandler {

    /**
     * The MODEL
     * The CONTROLLER is the only one allowed to modify the MODEL
     */
    private Match match;
    private VirtualView virtualView;

    public Controller(Match match, VirtualView virtualView) {
        this.match = match;
        this.virtualView = virtualView;
    }

    @Override
    public void update(Object arg){
        if( ! (arg instanceof ClientMessage))
            throw new RuntimeException("This must be an ClientMessage object");
        ClientMessage cm = (ClientMessage) arg;
        //cm.Accept(this);

        // TODO: not sure this is the best way to call correct method... test!
        // new Thread(() -> cm.Accept(this)).start();
    }

    @Override
    public void handleMessage(ConnectionClient message) {

    }

    @Override
    public void handleMessage(DisconnectionClient event) {

    }

    @Override
    public void handleMessage(ReConnectionClient message) {

    }

    @Override
    public void handleMessage(Ping event) {

    }

    @Override
    public void handleMessage(ChallengerChoseClient message) {

    }

    @Override
    public void handleMessage(PlayerChoseClient message) {

    }

    @Override
    public void handleMessage(WorkerInizializeClient message) {

    }

    @Override
    public void handleMessage(WorkerChoseClient message) {
        if(match.getCurrentPlayer().getName().equals(message.name) && match.getStatus().compareTo(Status.START) == 0){
            match.setStatus(match.getCurrentPlayer().getCard().getNextStatus(match.getStatus()));
            match.getCurrentPlayer().setCurrentWorker(message.worker);

            if(match.getCurrentPlayer().getCard().isQuestion()
                    && match.getCurrentPlayer().getCard().getStatus().compareTo(match.getStatus()) == 0
                    && match.getCurrentPlayer().getCard().activable(match.getPlayers(),match.getBoard())
            )
            {
                // TODO: must generate question message
            }
            else{
                match.getCurrentPlayer().getCard().getCheckMove(match.getPlayers(),match.getBoard());
                match.setStatus(match.getCurrentPlayer().getCard().getNextStatus(match.getStatus()));
            }
        }
    }

    @Override
    public void handleMessage(AnswerAbilityClient message) {

    }

    @Override
    public void handleMessage(MoveClient message) {

    }

    @Override
    public void handleMessage(BuildClient message) {

    }


    public void inizializeMatch() {

    }

    public void cardChoicheHandler() {

    }

    public void setupWorkerHandler() {

    }

    public void startTurn(){

    }

    public void endTurn(){

    }

}
