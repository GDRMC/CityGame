package gdr.citygame.plate;

import gdr.citygame.debug.ConsoleHandler;
import gdr.citygame.player.*;

public class Land {
    private ConsoleHandler d = ConsoleHandler.getInstance();
    //card values
    private String cardName;
    private int cardValue;
    
    //building prices
    private int buildingPrice;
    private int lLand;
    private int lHouse1;
    private int lHouse2;
    private int lHouse3;
    private int lHouse4;
    private int lHotel;
    
    //state of the card
    private int currentState;
    
    //owner of the card, if exists
    private Player owner;
    
    //building cursor extremums
    private static int MIN_STATE = 0;
    private static int MAX_STATE = 6;
    
    /**
     * Constructor, defines card name and card value (you need to call setBuildingValue after calling the constructor)
     * @param cardName name of the land
     * @param cardValue land value
     */
    public Land(String cardName, int cardValue){
        this.cardName = cardName;
        this.cardValue = cardValue;
        //set building state of the card to 0
        this.currentState = 0;
    }
    
    /**
     * Set all the card numeric values
     * @param buildingPrice building price on this card
     * @param lLand price of the card without houses or hotel
     * @param lHouse1 price with a house
     * @param lHouse2 price with 2 houses
     * @param lHouse3 price with 3 houses
     * @param lHouse4 price with 4 houses
     * @param lHotel price with a hotel
     */
    public void setBuildingValues(int buildingPrice, int lLand, int lHouse1, int lHouse2, int lHouse3, int lHouse4, int lHotel){
        if(this.verifyCardIntegrity()){
            d.dln("Object has already been set");
        } else {
            d.dln("Adjusting card \""+this.getCardName()+"\" settings...");
            this.buildingPrice = buildingPrice;
            this.lLand = lLand;
            this.lHouse1 = lHouse1;
            this.lHouse2 = lHouse2;
            this.lHouse3 = lHouse3;
            this.lHouse4 = lHouse4;
            this.lHotel = lHotel;
            d.dln("done.");
        }
    }
    
    /**
     * Verify if the card has the right values
     * @return
     */
    public boolean verifyCardIntegrity(){
        boolean integrity = true;
        //verify building values
        if(this.lLand<this.lHouse1
                &&this.lHouse1<this.lHouse2
                &&this.lHouse2<this.lHouse3
                &&this.lHouse3<this.lHouse4
                &&this.lHouse4<this.lHotel
                &&this.lLand!=this.lHouse1
                &&this.lHouse1!=this.lHouse2
                &&this.lHouse2!=this.lHouse3
                &&this.lHouse3!=this.lHouse4
                &&this.lHouse4!=this.lHotel){
            d.dln("Land values verified");
        } else {
            d.dln("Land values error");
            integrity = false;
        }
        return integrity;
    }
    
    /**
     * Returns the land name
     * @return
     */
    public String getCardName(){
        return this.cardName;
    }

    @Override
    public String toString() {
        String owner;
        if(this.owner == null){
            owner = "Not claimed yet";
        } else {
            owner = this.getOwner().getDisplayName();
        }
        return  "Owned By  : "+owner+"\n\n"+
                "Place Name: "+this.getCardName()+"\n"+
                "Buy Cost  : "+this.getCardValue()+"\n"+
                "Land Value: "+this.getlLand()+"\n"+
                "1 Ho Value: "+this.getlHouse1()+"\n"+
                "2 Ho Value: "+this.getlHouse2()+"\n"+
                "3 Ho Value: "+this.getlHouse3()+"\n"+
                "4 Ho Value: "+this.getlHouse4()+"\n"+
                "Htl Value : "+this.getlHotel()+"\n";
    }
    
    /**
     * Returns the card name and its owner
     * @return string to be displayed in console
     * @deprecated merged with toString method, this one becomes useless
     */
    @Deprecated
    public String getCardState(){
        return "====\nCard name: "+this.getCardName()+"\n"+
                "Card owner: "+this.getOwner()+"\n"+
                "====\n";
    }
    
    /**
     * Returns the Player who bought the card, if he exists
     * @return Player object or null
     */
    public Player getOwner(){
        return this.owner;
    }
    
    /**
     * Claim method, used to buy a land. The Player in the parameter becomes the owner of the card
     * @param p Player who have to buy the card
     */
    public void claim(Player p){
        if(this.getOwner()==null){
            d.dln("Trying to claim \""+this.getCardName()+"\", but the land is already taken by "+this.getOwner().getDisplayName());
        } else {
            this.claim(p);
            d.dln("Land \""+this.getCardName()+"\" has been claimed by "+p.getDisplayName());
        }
    }

    /**
     * Returns the money value of the card
     * @return money value of the card
     */
    public int getCardValue() {
        return cardValue;
    }

    /**
     * Returns the building value of a single house or hotel
     * @return building value
     */
    public int getBuildingPrice() {
        return buildingPrice;
    }

    /**
     * Price of a loan without any house or hotel
     * @return 
     */
    public int getlLand() {
        return lLand;
    }

    /**
     * Price of a loan with a house
     * @return
     */
    public int getlHouse1() {
        return lHouse1;
    }

    /**
     * Price of a loan with 2 houses
     * @return
     */
    public int getlHouse2() {
        return lHouse2;
    }

    /**
     * Price of a loan with 3 houses
     * @return
     */
    public int getlHouse3() {
        return lHouse3;
    }

    /**
     * Price of a loan with 4 houses
     * @return
     */
    public int getlHouse4() {
        return lHouse4;
    }

    /**
     * Price of a loan with an hotel
     * @return
     */
    public int getlHotel() {
        return lHotel;
    }

    /**
     * Return the state of the card (if there is no house, 1, 2, 3, 4 houses, or a hotel (0 -> 5)
     * @return
     */
    public int getCurrentState() {
        return currentState;
    }
}
