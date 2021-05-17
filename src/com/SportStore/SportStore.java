package com.SportStore;

import java.util.ArrayList;
import java.util.HashSet;

public class SportStore {
    private String name;
    private HashSet<Customer> customers;
    private HashSet<Cashier> employees;
    private ArrayList<Product> products;
    private HashSet<Basket> baskets;
    private Manager manager;
    private HashSet<CashRegister> cashRegisters;

    public SportStore(String name) {
        this.name = name;
        this.baskets = new HashSet<>();
        this.customers = new HashSet<>();
        this.employees = new HashSet<>();
        this.cashRegisters = new HashSet<>();
        this.products = new ArrayList<>();
    }

    public HashSet<Basket> getBaskets() {
        return this.baskets;
    }

    public void setBaskets(HashSet<Basket> baskets) {
        this.baskets = baskets;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(HashSet<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public boolean addProduct(Product product) {
        return this.products.add(product);
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public boolean addCashiers(Cashier employee) {

        return this.employees.add(employee);
    }

    public void addManager(Manager manager) {
        this.manager = manager;
    }

    public HashSet<Cashier> getCashiers() {
        return this.employees;
    }

    public Manager getManager() {
        return this.manager;
    }

    public boolean addCustomer(Customer customer) {
        return this.customers.add(customer);

    }

    public boolean addBaskets(Basket basket) {
        return this.baskets.add(basket);
    }

    /**
     * The method add product to a customer's basket
     * @param idForBasket the number of the basket
     * @param barCode the code for the product
     * @return returns true if the product is being added to the basket,false if the product was not.
     */
    public boolean addProductToCustomer(int idForBasket, String barCode) {
        for (Basket basket : this.getBaskets()) {
            if (basket.getNumber() == idForBasket && !basket.isBasketAvailable()) {
                for (Product product : this.getProducts()) {
                    if (product.getQRCode().equals(barCode)) {
                        return basket.addProducts(product);
                    }
                }
            }
        }
        return false;
    }

    public boolean addCashRegisters(CashRegister cashRegister) {
        return this.cashRegisters.add(cashRegister);
    }

    public HashSet<CashRegister> getCashRegisters() {
        return cashRegisters;
    }

    public void setCashRegisters(HashSet<CashRegister> cashRegisters) {
        this.cashRegisters = cashRegisters;
    }

    /**
     * The method adds a customer to a cashRegister
     * @param cashRegister the cashRegister where the customer should be added
     * @param customer the customer to be added
     * @return returns true if the customer has been added,false if he was not added.
     */
    public boolean addCustomerToCashRegister(CashRegister cashRegister, Customer customer) {
        for (CashRegister cashRegisters : this.getCashRegisters()) {
            if (cashRegisters.equals(cashRegister)) {
                for (Customer customers : this.getCustomers()) {
                    if (customers.equals(customer)) {
                        return cashRegister.addCustomers(customer);
                    }
                }
            }
        }
        return false;
    }
}
