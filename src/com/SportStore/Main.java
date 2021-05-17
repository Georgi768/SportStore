package com.SportStore;


import com.SportStore.Exceptions.CustomerIsNotInCashRegisterExceptions;

public class Main {
    public static void main(String[] args) throws CustomerIsNotInCashRegisterExceptions {
        SportStore sportStore = new SportStore("Esports");

        Basket basket1 = new Basket(1);
        Basket basket2 = new Basket(2);
        sportStore.addBaskets(basket1);
        sportStore.addBaskets(basket2);


        Product dumbbells = new Product("123512", ProductType.OTHER, 25.5);
        Product shirt = new Product("123512", ProductType.FOOTBALL_CLOTHES_SET, 50);
        Product shoes = new Product("123512", ProductType.GYM_SHOES, 120);

        Customer gordon = new Customer(321, "Gordon", "13-02-1976", 25, sportStore);
        Customer floyd = new Customer(111, "Floyd", "26-06-2000", 13, sportStore);

        gordon.addBasket(basket1);
        floyd.addBasket(basket2);

        Cashier williams = new Cashier(5, "Williams", "12-12-1988", sportStore);
        Cashier lilly = new Cashier(123, "Lilly", "12-12-1999", sportStore);
        CashRegister cashRegister = new CashRegister(5, lilly);
        CashRegister willaimSRegister = new CashRegister(6, williams);
        sportStore.addCashRegisters(cashRegister);
        sportStore.addCashRegisters(willaimSRegister);

        Manager manager = new Manager(1, "George", "13-01-1991", sportStore);
        manager.addCashiers(williams);
        manager.addCashiers(lilly);

        sportStore.addManager(manager);
        sportStore.addCashiers(lilly);
        sportStore.addCustomer(floyd);
        sportStore.addCustomer(gordon);
        sportStore.addProduct(dumbbells);
        sportStore.addProduct(shirt);
        sportStore.addProduct(shoes);

        basket1.addProducts(shirt);
        basket1.addProducts(dumbbells);
        basket2.addProducts(shoes);
        System.out.println("-------TotalPayment for both baskets-------");
        System.out.println(basket1.getPrice());
        System.out.println(basket2.getPrice());

        cashRegister.addCustomers(floyd);
        sportStore.addCustomerToCashRegister(willaimSRegister,gordon);

        System.out.println("-------TotalPayment from cashregister-------");
        System.out.println(cashRegister.calculatePayment(floyd));
        willaimSRegister.calculatePayment(gordon);

        System.out.println("-------Setting the employee of the month-------");
        System.out.println(manager.setEmployeeOfTheMonth().getName());

        System.out.println("-------checking payment for Cashiers and manager-------");
        System.out.println(lilly.getName() + " " + lilly.paymentPerHour());
        System.out.println(williams.getName() + " " + williams.paymentPerHour());
        System.out.println(manager.getName() + " " + manager.paymentPerHour());
    }
}
