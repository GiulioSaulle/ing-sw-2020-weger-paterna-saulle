package it.polimi.ingsw.cards;

import it.polimi.ingsw.model.Board;
import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Status;
import it.polimi.ingsw.model.Worker;

import java.util.List;

public class Prometheus extends Card {

    public Prometheus()
    {
        super(CardName.PROMETHEUS,false,false,true, Status.CHOSEN);
    }

}
