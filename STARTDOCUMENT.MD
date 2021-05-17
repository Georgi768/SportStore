# java3-end-assignment

## Problem description
The sport store wants to digitalize all their files about its products,customers and employees.

The store includes information about its employees and customers and there are different types of employees.
<br>The people who are part of the store are:
* **Cashier**.<br>
  The Cashiers have a queue of all customers and have a list of how many points the customers have.
* **Manager**.<br>
  The manager will have an overview lists of all the cashiers in the store and have information about their totalSales.He determines who is the employee of the month depending on the totalSales.<br>
  Both Cashier and manager have payment per hour and can set vacations
* **CashRegister**<br>
  The cashRegister stores a cashier and the customer to a queue.They remove the customers from the queue and add to the cashiers their totalsales.
* **Customer**<br>
  The customers are the ones who have points.They can have a basket and have products in their basket.Every customer who has 10 or more points will have discount.The discount include:<br>
  When they have 10 points - 10% off,20 points - 20% off,30 or more - 30%.<br>
  The discount can be applied if their payment price is more than 15 euro.
## Inputs,calculation and outputs
In this section the inputs, calculation and outputs will be described.
## Input
##### Customer

|     Case       |       Type        | Condition|
|----------------|-------------------|----------|
|customerNumber  | int               |not empty |
|customerName    | String            |not empty |
|date Of birth   |String             |dd-mm-yy  |
|customerPoints  |Integer            |    >= 0  |

##### basket
|     Case       |       Type        | Condition|
|----------------|-------------------|----------|
|basketNumber    |Integer            |    > 0   |

##### CashRegister
|     Case         |       Type        | Condition|
|------------------|-------------------|----------|
|cashRegisterNumber|Integer            |    > 0   |
|cashier           |Cashier            |    > 0   |

##### Product
|     Case       |       Type        | Condition|
|----------------|-------------------|----------|
|productBarCode  |String             |not empty |
|productType     |productType(enum)  |not empty |
|productPrice    |double             |    > 0   |

##### SportStore
|Case  |Type    | Condition|
|------|--------|----------|
|name  |String  |not empty |

##### Employee
|   Case    |  Type   | Condition |
|-----------|---------|-----------|
|idNumber   |Integer  |    > 0    |
|name       |String   |not empty  |
|dateOfBirth|String   |dd-mm-yy   |

## Calculations
|       Case       |  Type  |                 Calculation                  |                     Condition                     |
|------------------|--------|----------------------------------------------|---------------------------------------------------| 
|Calculate daysGone|Integer |daysGone=(VacationDateEnd-VacationDateStart)  |daysGone > 0<br>VacationDateStart < vacationDateEnd|
|add  discount     |double  |          discount=0                          |customerPoints <=9                                 |  
|add  discount     |double  |          Discount=0.1                        |customerPoints >=10 && customerPoints <= 19        |  
|add  discount     |double  |          Discount=0.2                        |customerPoints >=20 && customerPoints <= 29        |  
|add  discount     |double  |          Discount=0.3                        |customerPoints >=30                                |
|CalculatePayment  |double  |Payment=paymentBasket-paymentBasket * Discount|paymentBasket >= 15.00                             |
|paymentBasket     |double  |          PaymentBasket+=ProductPrice         |paymentBasket >= 15.00                             |
|payment per hour  |double  |          paymentPerHour - paymentCut         |            paymentPerHour = 20                    |
|payment per hour  |double  |          paymentPerHour + paymentRaise       |            paymentPerHour = 9                     |

## Output
|                       Case                          |  Type   |
|-----------------------------------------------------|---------|
|Total payment from basket                            |Double   |
|The employee of the month                            |String   |
|The points of the customer                           |Integer  |
|Days when the Cashier can return from work           |Integer  |
|TotalPayment from cashRegister when customer is payed|Integer  |
|payment per hour                                     |Integer  |
|Calculate days gone                                  |Integer  |

## UML diagram
In this section an uml diagram will be provided.

![umlDiagram](../images/finalUMLDiagram.png
"Improved version of UML")

## Remarks
* Inputs will be validated
* **System.out.printLine** will be provided in main only
* The start vacation date cannot be bigger that the end vacation date.
* Unit test will be provided
* The payment has to be 15.0 euros or more for the discount to apply on the purchase
* JavaDoc will be provided

## Test plan
In this section test data, and the test cases will be proviced.

#### Customer
|ObjectName|  Object type   | name  | idNumber| Date of Birth    | Points |
 |----------|----------------|-------|---------|------------------|--------|
|abid      |Customer        | Abid  |1        |  16-07-1994      |   8    |
| john     |Customer        | John  |5        |  27-01-1992      |   35   |

#### SportStore
|ObjectName|  Object type   | name  |
 |----------|----------------|-------|
|store     |SportStore      |Adidas |

#### Basket
|ObjectName|  Object type   | number|
 |----------|----------------|-------|
|basket1   |Basket          |1      |
|basket2   |Basket          |2      |

#### CashRegister
|ObjectName  |  Object type   | number|   Cashier     |
  |------------|----------------|-------|---------------|
|cashRegister|CashRegister    |1      |CashierM       |

#### Product
|ObjectName  |  Object type   | bar code| product type | price| 
|------------|----------------|---------|--------------|------|
|nikeStreet  |Product         |321312   |runningShoes  |43.99 |
|dumbbells   |Product         |12512    |Other         |115   |
|sportTshirt |Product         |1234     |runningClothes|14.0  |

#### Employee
|ObjectName  |  Object type   | idNumber|  name        | date of birth| 
|------------|----------------|---------|--------------|--------------|
|managerG    |Manager         |5        |Georgi        |10-09-2000    |
|cashierM    |Cashier         |8        |Michele       |08-02-1999    |
|cashierI    |Cashier         |5        |Ivan          |01-01-1980    |

## Test case

### addBasket
This section will describe `addBasket()` if it's working correctly

|#   |  Customer     |       Action              |Expected output   |
 |---:|---------------|---------------------------|------------------|
| 1  | abid          |`addBasket(basket1:Basket)`|       True       |
| 2  | john          |`addBasket(basket2:Basket)`|       True       |

##### addBasketAssertOnlyOneBasketCanBeTaken
|#   |  Customer     |       Action              |Expected output   |
  |---:|---------------|---------------------------|------------------|
| 1  | abid          |`addBasket(basket1:Basket)`|       True       |
| 2  | john          |`addBasket(basket1:Basket)`|       false       |

### addProductsToBasket

This section will describe `addProductsToBasket()` if it's working correctly.

##### addProductsToBasketAssertTrue

|#   |  Basket    |       Action                            |Expected output   |
 |----|------------|-----------------------------------------|------------------|
| 1  | basket1    |`addProductsToBasket(Product:nikeStreet)`|       True       |
| 2  | basket2    |`addProductsToBasket(Product:dumbbells)` |       True       |

### getPrice()
This section will describe `getPrice()` if it's working correctly.

##### addProductsToBasketAssertTrue


|#   |  Basket    |       Action                            |Expected output   |
 |----|------------|-----------------------------------------|------------------|
| 1  | basket1    |` getPrice()                            `|       43.99      |
| 2  | basket2    |` getPrice()                            `|       115        |

##### getPricePriceAssertedBasketIsEmpty

|#   |  Basket    |       Action                             |Expected output   |
|----|------------|------------------------------------------|------------------|
| 1  | basket1    |`getPrice()`                              |       0          |

### addCashier

This section will describe `addCashier` how it works

##### AddCashierAssertTrue

|#   |  SportStore|       Action                             |Expected output   |
|----|------------|------------------------------------------|------------------|
| 1  | store      |`addCashier(Cashier:cashierM)`            |       True       |

### addCustomerToCashRegister

This section will describe `addCustomerToCashRegister` how it works

##### addCustomerToCashierAssertTheCustomerAndCashierAreInTheList

|#   |  SportStore|       Action                                                           |Expected output   |
|----|------------|------------------------------------------------------------------------|------------------|
| 1  | store      |`addCustomerToCashRegister(CashRegister:cashRegister,Customer:abid)`    |       True       |

##### addCustomerToCashierAssertFalseIfNoObjectAreInStore

|#   |  SportStore|       Action                                                           |Expected output  |
|----|------------|------------------------------------------------------------------------|-----------------|
| 1  | store      |`addCustomerToCashRegister(CashRegister:cashRegister,Customer:abid)`    |       False     |

##### addCustomerToCashierAssertMoreThanFiveCustomersAdded

|#   |  SportStore|       Action                                                           |Expected output  |
|----|------------|------------------------------------------------------------------------|-----------------|
| 1  | store      |`addCustomerToCashRegister(CashRegister:cashRegister,Customer:abid)`    |       False     |

### addProductToCustomer

This section will describe `addProductToCustomer` how it works

##### addProductToCustomerAssertTrueIfProductAndCustomerExistInStore

|#   |  SportStore|       Action                                                           |Expected output  |
|----|------------|------------------------------------------------------------------------|-----------------|
| 1  | store      |`addProductToCustomer(int:1,String:321312)`                             |       true      |

##### addProductToCustomerAssertFalseIfCustomersAreNotInStore

|#   |  SportStore|       Action                                                           |Expected output  |
|----|------------|------------------------------------------------------------------------|-----------------|
| 1  | store      |`addProductToCustomer(int:1,String:321312)`                             |       false     |

### calculatePayment

This section will describe `calculatePayment` if it properly works

##### calculatePaymentAssureTotalSalesAreAdded(Discount)

|#   | CashRegister   |       Action                      |Expected output   |
|----|----------------|-----------------------------------|------------------|
| 1  | cashRegister   |` calculatePayment(Customer:john)` |   30.79      |

##### calculatePaymentAssureCustomerIsRemoved

|#   | CashRegister   |       Action                      |Expected output   |
|----|----------------|-----------------------------------|------------------|
| 1  | cashRegister   |` calculatePayment(Customer:john)` |      None

### getEmployeeOfTheMonth
This section will describe the functionality of `getEmployeeOfTheMonth`

|#   | SportStore    |       Action                   |Expected output   |
|----|------------|-----------------------------------|------------------|
| 1  | store      |` getEmployeeOfTheMonth()`         |     Michele      |

### calculateDaysGone
This section will describe the functionality of `calculateDaysGone`

##### calculateDaysGoneAssertTheDatesAreCorrect

|#   |  Employee                |       Action                      |Expected output   |
|----|--------------------------|-----------------------------------|------------------|
| 1  | cashierG                 |` calculateDaysGone()`             |     18           |

##### calculateDaysGoneAssertNoDatesHaveBeenSet

|#   |  Employee                |       Action                  |Expected output   |
|----|--------------------------|-------------------------------|------------------|
| 1  | managerG                 |` calculateDaysGone()`         |     0            |
