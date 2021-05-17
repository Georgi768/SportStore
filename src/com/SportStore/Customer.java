package com.SportStore;


public class Customer extends Person {
    private int points;
    private Basket baskets;

    public Customer(int id, String name, String dateOfBirth, int points, SportStore sportStore) {
        super(id, name, dateOfBirth, sportStore);
        if(points < 0)
        {
            this.setPoints(0);
        }else
        {
            this.points = points;
        }
        this.baskets = null;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String toString() {
        return "Name: " + this.getName() + " points: " + this.getPoints() + " DateOfBirth: " + this.getDateOfBirth();
    }

    public void addPoints(int points) {
        this.points += points;
    }


    public Basket getBaskets() {
        return this.baskets;
    }

    public void setBaskets(Basket baskets) {
        this.baskets = baskets;
    }

    /**
     * This method adds basket to a customer if the basket is not already taken.
     * it checks if the basket is located in the sport store
     * @param basket the specific basket to be added
     * @return true if the basket is added successfully,false if something went wrong
     */
    public boolean addBasket(Basket basket) {
        for (Basket abasket : this.getSportStore().getBaskets()) {
            if (abasket.getNumber() == basket.getNumber() && abasket.isBasketAvailable()) {
                abasket.setAvailable(false);
                this.baskets = abasket;
                return true;
            }
        }
        return false;
    }
}
