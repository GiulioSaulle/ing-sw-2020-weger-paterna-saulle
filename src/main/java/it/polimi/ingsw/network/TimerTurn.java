package it.polimi.ingsw.network;

import java.util.TimerTask;

public class TimerTurn extends TimerTask {

    /**
     * The client
     */
    ServerClientHandler sch;

    /**
     * @param sch the client
     */
    public TimerTurn(ServerClientHandler sch){
        //System.out.println("TIMER END!");
        this.sch = sch;
    }

    /**
     * The timer task runs every 1 second and send the countdown to the client
     */
    @Override
    public void run() {
        //sch.turnTimesUp = true;
        this.cancel();
    }
}