package it.polimi.ingsw.model;

import it.polimi.ingsw.model.cards.Card;
import it.polimi.ingsw.model.cards.CardName;
import it.polimi.ingsw.model.cards.FactoryCard;

public class Player {

    /**
     * Username
     */
    private String name;

    /**
     * His card, must be assigned by FACTORY class
     */
    private Card card;

    /**
     * Workers
     */
    private Worker worker1,worker2;

    /**
     * True if this is the current player
     */
    private boolean active;

    public Player(String name)
    {
        this.name = name;
        this.card = null; //FactoryCard.getCard(card);
        this.worker1 = null;
        this.worker2 = null;
        this.active = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    /**
     * The card is instanced by FACTORY class
     * @param card value from card ENUM
     */
    public void setCard(CardName card) {
        this.card = FactoryCard.getCard(card);

        // TODO: notifico tutti i giocatori della scelta fatta (CardChosenServer)
    }

    public Worker getWorker1() {
        return worker1;
    }

    public void setWorker1(Worker worker1) {
        this.worker1 = worker1;

        // TODO: notify all (ricordarsi di aggiungere nel messaggio chi è worker) (WorkerChosenServer)
    }

    public Worker getWorker2() {
        return worker2;
    }

    public void setWorker2(Worker worker2) {
        this.worker2 = worker2;
    }

    public void setActive(boolean active){
        this.active=active;
    }

    public boolean isActive(){
        return active;
    }

    public Worker getCurrentWorker(){
         if(getWorker1().isActive())
             return worker1;
         else if(getWorker2().isActive())
             return worker2;
         else return null;
    }

    /**
     * Only one worker a time could be active
     * @param i 1 first worker, 2 the second one
     */
    public void setCurrentWorker(int i)
    {
        if(i==1||i==2) {
            worker1.setActive(i == 1);
            worker2.setActive(i == 2);
        }
    }

    public void doQuestion(){
        // TODO: notify con name settato sul suo nome (QuestionAbilityServer)
    }
}
