package com.SportStore;


public class Cashier extends Employee {
    private double totalSales;

    public Cashier(int id, String name, String dateOfBirth, SportStore sportStore) {
        super(id, name, dateOfBirth, sportStore);
        this.totalSales = 0;
    }

    /**
     * This method determines the payment which the cashier gets per hour depending on the totalSales he has made
     * @return returns the payment
     */
    @Override
    public double paymentPerHour() {
        double paymentHour = 9;
        double paymentRaise;
        if (this.totalSales > 2000 && this.totalSales < 5000) {
            paymentRaise = 2;
        } else if (this.totalSales >= 5000) {
            paymentRaise = 5;
        } else {
            paymentRaise = 0;
        }
        return paymentHour + paymentRaise;
    }

    public void addToTotalSales(double sales) {
        this.totalSales += sales;
    }

    public double getTotalSales() {
        return this.totalSales;
    }
}
