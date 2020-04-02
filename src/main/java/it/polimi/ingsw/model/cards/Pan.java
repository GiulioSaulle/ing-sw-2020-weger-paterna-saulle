package it.polimi.ingsw.model.cards;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Status;

public class Pan extends Card {

    public Pan()
    {
        super(CardName.PAN,false,false,false, Status.MOVED);
    }



    /**
     * Controlla se il giocatore è riuscito a vincere saltando da 2 piani
     * in caso negativo, fa un controllo classico di vincita.
     */
    @Override
    public boolean checkWin(Cell from, Cell to) throws NullPointerException {
            if(from == null || to == null) return false;
            else if (from.getLevel() == 2 && to.getLevel() == 0)
                return true;
            else
                return super.checkWin(from, to);

    }
}


