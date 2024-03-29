package it.polimi.ingsw.commons.clientmessages;

import it.polimi.ingsw.commons.ClientMessage;
import it.polimi.ingsw.controller.ClientMessageHandler;
import it.polimi.ingsw.network.ServerClientHandler;

public class ModeChoseClient extends ClientMessage {
    /**
     * This messagge will be send to the server from the client the Game Mode Chosen by the player [2 or 3]
     * Controller doesn't use this message
     * @param cmh nullable
     */
    @Override
    public void accept(ClientMessageHandler cmh) {cmh.handleMessage(this);}

    public final int mode;
    public transient ServerClientHandler sch = null;

    public transient boolean forced;
    public boolean refused;

    public ModeChoseClient(String name, int mode){
        super(name);
        this.mode=mode;
        forced = false;
        refused = false;
    }
        public ModeChoseClient(String name, int mode, boolean refused){
        super(name);
        this.mode=mode;
        forced = false;
        this.refused = refused;
    }
}
