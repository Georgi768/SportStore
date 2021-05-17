package com.SportStore;

import com.SportStore.Exceptions.CustomerIsNotInCashRegisterExceptions;

import java.util.HashSet;
import java.util.Iterator;

public class CashRegister {
    private int number;
    private Cashier cashier;
    private HashSet<Customer> customers;

    public CashRegister(int number, Cashier cashier) {
        this.number = number;
        this.cashier = cashier;
        this.customers = new HashSet<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public HashSet<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(HashSet<Customer> customers) {
        this.customers = customers;
    }


    /**
     * This method adds customers to the list and checks if the customer is in the store.
     * @param customer the specific customer that needs to be added
     * @return returns true if added successfully or false if something goes wrong
     */
    public boolean addCustomers(Customer customer) {
        for (Customer aCustomer : this.getCashier().getSportStore().getCustomers()) {
            if (aCustomer.equals(customer) && this.customers.size() < 5) {
                return customers.add(aCustomer);
            }
        }
        return false;
    }

    /**
     * The methods adds discount percentages on the customer's payment depending of how much points he has
     * @param customer the specific customer to which to add a discount
     * @return returns the discount that needs to be added
     */
    private double addDiscount(Customer customer) {
        double discount = 0;
        for (Customer aCustomer : this.customers) {
            if (aCustomer.equals(customer)) {
                if (aCustomer.getPoints() < 10) {
                    discount = 0;
                } else if (aCustomer.getPoints() >= 10 && aCustomer.getPoints() <= 20) {
                    discount = 0.1;
                } else if (aCustomer.getPoints() >= 20 && aCustomer.getPoints() <= 30) {
                    discount = 0.2;
                } else {
                    discount = 0.3;
                }
            }
            if (aCustomer.getBaskets().getPrice() < 15) {
                discount = 0;
            }
        }
        return discount;
    }

    /**
     * Remove the customer from the list
     * @param name the name of the customer
     */
    private void removeCustomer(String name) {
        Iterator<Customer> iterator = this.customers.iterator();
        while (iterator.hasNext()) {
            Customer next = iterator.next();
            if (next.getName().contentEquals(name)) {
                iterator.remove();
            }
        }
    }

    /**
     * This method calculate the payment of the customer depending on the discount.
     * It removes the customer when the process is finished and adds a point if the payment is more than 15
     * @param customer  the specific customer to calculate the payment
     * @return returns the final payment of the customer
     */
    public double calculatePayment(Customer customer) throws CustomerIsNotInCashRegisterExceptions {
        double basketPayment;
        for (Customer customers : this.getCustomers()) {
            if (customers.equals(customer)) {
                double totalPayment;
                basketPayment = customers.getBaskets().getPrice();
                totalPayment = basketPayment - basketPayment * addDiscount(customers);
                customers.addPoints(1);
                this.removeCustomer(customers.getName());
                this.getCashier().addToTotalSales(totalPayment);
                return totalPayment;
            }
        }
        throw new CustomerIsNotInCashRegisterExceptions();
    }
}
