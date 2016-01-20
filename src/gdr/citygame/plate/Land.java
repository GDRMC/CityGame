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
    
    
    public Land(String cardName, int cardValue){
        this.cardName = cardName;
        this.cardValue = cardValue;
        //set building state of the card to 0
        this.currentState = 0;
    }
    
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
    
    public String getCardState(){
        return "====\nCard name: "+this.getCardName()+"\n"+
                "Card owner: "+this.getOwner()+"\n"+
                "====\n";
    }
    
    public Player getOwner(){
        return this.owner;
    }
    
    public void claim(Player p){
        if(this.getOwner()==null){
            d.dln("Trying to claim \""+this.getCardName()+"\", but the land is already taken by "+this.getOwner().getDisplayName());
        } else {
            this.claim(p);
            d.dln("Land \""+this.getCardName()+"\" has been claimed by "+p.getDisplayName());
        }
    }

    public int getCardValue() {
        return cardValue;
    }

    public int getBuildingPrice() {
        return buildingPrice;
    }

    public int getlLand() {
        return lLand;
    }

    public int getlHouse1() {
        return lHouse1;
    }

    public int getlHouse2() {
        return lHouse2;
    }

    public int getlHouse3() {
        return lHouse3;
    }

    public int getlHouse4() {
        return lHouse4;
    }

    public int getlHotel() {
        return lHotel;
    }

    public int getCurrentState() {
        return currentState;
    }
    
    
}
