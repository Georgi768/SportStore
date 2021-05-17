package com.SportStore;

import java.util.HashSet;

public class Manager extends Employee {
    private HashSet<Cashier> cashiers;

    public Manager(int id, String name, String dateOfBirth, SportStore sportStore) {
        super(id, name, dateOfBirth, sportStore);
        this.cashiers = new HashSet<>();
    }

    /**
     * The method determines the payment per hour of the manager depending on how much days he had taken for vacation
     * @return the payment per hour
     */
    @Override
    public double paymentPerHour() {
        double paymentPerHour = 20;
        double paymentCut;
        if (this.calculateDaysGone() == 0) {
            paymentCut = 0;
        } else if (this.calculateDaysGone() < 15) {
            paymentCut = 2;
        } else if (this.calculateDaysGone() >= 15 && this.calculateDaysGone() <= 30) {
            paymentCut = 5;
        } else {
            paymentCut = 8;
        }
        return paymentPerHour - paymentCut;

    }

    public boolean addCashiers(Cashier cashier) {
        return this.cashiers.add(cashier);
    }

    public Cashier setEmployeeOfTheMonth() {
        Cashier employeeOfTheMonth = null;
        for (Cashier cashiers : this.getSportStore().getCashiers()) {
            if (employeeOfTheMonth == null) {
                employeeOfTheMonth = cashiers;
            }
            if (employeeOfTheMonth.getTotalSales() < cashiers.getTotalSales()) {
                employeeOfTheMonth = cashiers;
            } else if (employeeOfTheMonth.getTotalSales() == cashiers.getTotalSales()) {
                if (employeeOfTheMonth.calculateDaysGone() > cashiers.calculateDaysGone()) {
                    employeeOfTheMonth = cashiers;
                }
            }
        }
        return employeeOfTheMonth;
    }
}
