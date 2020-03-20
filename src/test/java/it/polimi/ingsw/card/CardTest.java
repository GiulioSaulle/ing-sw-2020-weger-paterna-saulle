package it.polimi.ingsw.card;

import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.cards.CardName;
import it.polimi.ingsw.cards.FactoryCard;
import it.polimi.ingsw.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CardTest {
    // checkWin
    @Test
    public void checkWin_cellNull()
    {
        Card c = FactoryCard.getCard(CardName.APOLLO);
        assertNotNull(c);
        assertFalse(c.checkWin(null,new Cell(0,0,0)));
        assertFalse(c.checkWin(new Cell(0,0,0),null));
    }
    @Test
    public void checkWin_cellOut()
    {
        Card c = FactoryCard.getCard(CardName.APOLLO);
        assertNotNull(c);
        assertFalse(c.checkWin(new Cell(5,5,0),new Cell(0,0,0)));
        assertFalse(c.checkWin(new Cell(0,0,0),new Cell(5,5,0)));
    }
    @Test
    public void checkWin_win()
    {
        Card c = FactoryCard.getCard(CardName.APOLLO);
        assertNotNull(c);
        assertTrue(c.checkWin(new Cell(4,4,2),new Cell(4,3,3)));
    }
    @Test
    public void checkWin_notWin()
    {
        Card c = FactoryCard.getCard(CardName.APOLLO);
        assertNotNull(c);
        assertFalse(c.checkWin(new Cell(4,4,3),new Cell(3,4,3)));
    }
    // checkBuild
    @Test
    public void checkBuild_paramsNull()
    {
        Card c = FactoryCard.getCard(CardName.APOLLO);
        List<Player> p = new ArrayList<>();
        p.add(new Player("player1",CardName.APOLLO,new Worker(0,0),new Worker(0,0)));
        p.add(new Player("player2",CardName.ARTEMIS,new Worker(0,0),new Worker(0,0)));
        p.add(new Player("player3",CardName.ATLAS,new Worker(0,0),new Worker(0,0)));
        assertNotNull(c);
        assertEquals(c.checkBuild(null,new Board()).size(),0);
        assertEquals(c.checkBuild(p,null).size(),0);
    }
    @Test
    public void checkBuild_noCurrentPlayerWorker()
    {
        Card c = FactoryCard.getCard(CardName.PAN);
        List<Player> p = new ArrayList<>();
        p.add(new Player("player1",CardName.APOLLO,new Worker(0,0),new Worker(0,0)));
        p.add(new Player("player2",CardName.ARTEMIS,new Worker(0,0),new Worker(0,0)));
        p.add(new Player("player3",CardName.ATLAS,new Worker(0,0),new Worker(0,0)));
        assertNotNull(c);
        assertEquals(c.checkBuild(p,new Board()).size(),0);
        assertEquals(c.checkBuild(p,new Board()).size(),0);
    }
    @Test
    public void checkBuild()
    {
        List<Player> p = new ArrayList<>();
        p.add(new Player("player1",CardName.APOLLO,new Worker(2,3),new Worker(0,0)));
        p.add(new Player("player2",CardName.ARTEMIS,new Worker(4,0),new Worker(0,1)));
        p.add(new Player("player3",CardName.ATLAS,new Worker(2,2),new Worker(0,2)));
        p.get(0).setCurrentWorker(1);
        Board b = new Board();
        for(Cell c:b.getField()){
            if(c.getRow() == 1 && c.getColumn() == 2)
                c.setLevel(1);
            else if(c.getRow() == 1 && c.getColumn() == 3)
                c.setLevel(2);
            else if(c.getRow() == 1 && c.getColumn() == 4)
                c.setLevel(3);
            else if(c.getRow() == 2 && c.getColumn() == 4)
                c.setLevel(4);
            else if(c.getRow() == 3 && c.getColumn() == 2)
                c.setLevel(4);
            else if(c.getRow() == 3 && c.getColumn() == 3)
                c.setLevel(4);
            else if(c.getRow() == 3 && c.getColumn() == 4)
                c.setLevel(4);
        }
        assertNotNull(p);
        assertNotNull(b);
        List<Cell> ret = p.get(0).getCard().checkBuild(p,b);
        for(Cell c:ret)
            System.out.println(c.getRow() + " - " + c.getColumn());
        assertEquals(ret.size(),3);
        for(Cell c:ret)
            assertTrue(c.getRow() == 1 && c.getColumn() == 2 || c.getRow() == 1 && c.getColumn() == 3 || c.getRow() == 1 && c.getColumn() == 4);
    }
    // checkMove
    @Test
    public void checkMove_paramsNull()
    {
        Card c = FactoryCard.getCard(CardName.APOLLO);
        List<Player> p = new ArrayList<>();
        p.add(new Player("player1",CardName.APOLLO,new Worker(0,0),new Worker(0,0)));
        p.add(new Player("player2",CardName.ARTEMIS,new Worker(0,0),new Worker(0,0)));
        p.add(new Player("player3",CardName.ATLAS,new Worker(0,0),new Worker(0,0)));
        assertNotNull(c);
        List<Cell> ret = c.checkMove(p,null);
        assertEquals(ret.size(),0);
        ret = c.checkMove(null,new Board());
        assertEquals(0, ret.size());
    }
    @Test
    public void checkMove_noCurrentPlayerWorker()
    {
        Card c = FactoryCard.getCard(CardName.PAN);
        List<Player> p = new ArrayList<>();
        p.add(new Player("player1",CardName.APOLLO,new Worker(0,0),new Worker(0,0)));
        p.add(new Player("player2",CardName.ARTEMIS,new Worker(0,0),new Worker(0,0)));
        p.add(new Player("player3",CardName.ATLAS,new Worker(0,0),new Worker(0,0)));
        assertNotNull(c);
        assertEquals(c.checkMove(p,new Board()).size(),0);
        assertEquals(c.checkMove(p,new Board()).size(),0);
    }
    @Test
    public void checkMove()
    {
        List<Player> p = new ArrayList<>();
        p.add(new Player("player1",CardName.APOLLO,new Worker(2,3),new Worker(0,0)));
        p.add(new Player("player2",CardName.ARTEMIS,new Worker(4,0),new Worker(0,1)));
        p.add(new Player("player3",CardName.ATLAS,new Worker(2,2),new Worker(0,2)));
        p.get(0).setCurrentWorker(1);
        Board b = new Board();
        for(Cell c:b.getField()){
            if(c.getRow() == 1 && c.getColumn() == 2)
                c.setLevel(1);
            else if(c.getRow() == 1 && c.getColumn() == 3)
                c.setLevel(2);
            else if(c.getRow() == 1 && c.getColumn() == 4)
                c.setLevel(3);
            else if(c.getRow() == 2 && c.getColumn() == 4)
                c.setLevel(4);
            else if(c.getRow() == 3 && c.getColumn() == 2)
                c.setLevel(4);
            else if(c.getRow() == 3 && c.getColumn() == 3)
                c.setLevel(4);
            else if(c.getRow() == 3 && c.getColumn() == 4)
                c.setLevel(4);
        }
        assertNotNull(p);
        assertNotNull(b);
        List<Cell> ret = p.get(0).getCard().checkMove(p,b);
        for(Cell c:ret)
            System.out.println(c.getRow() + " - " + c.getColumn());
        assertEquals(ret.size(),1);
        for(Cell c:ret){
            assertEquals(c.getRow() , 1);
            assertEquals(c.getColumn() , 2);
        }
    }
    // getBlock
    @Test
    public void getBlock()
    {
        Card c = FactoryCard.getCard(CardName.APOLLO);
        assertNotNull(c);
        assertEquals(c.getBlock(new Worker(0,0),new Board(), Status.CHOSEN).size(),0);
    }
}
