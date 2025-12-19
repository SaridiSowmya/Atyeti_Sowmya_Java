1) HOW TO RUN THE APPLICATION
============================ 

->> Clone or download the project
  
->> Place your CSV input files inside the resources/ directory.

->> Build & run 

    Using IntelliJ / Eclipse

    Open the project

    Right-click Main class → Run

   The program will:

    Read and merge all CSV input files

    Validate orders

    Insert into order books

    Match buy & sell orders

    Print trades

    Output summary or errors

--------------------------------------------------------------------------------------------------

2)DESIGN PATTERNS USED AND WHY?
===============================
 Strategy pattern
 ------------------
“Strategy Pattern allows selecting an algorithm at runtime.
It defines a family of algorithms, encapsulates each one, and makes them interchangeable without modifying the client code.
It removes long if-else chains and follows the open-closed principle.”

in my code i have used:
------------------------

* OrderBook interface with OrderBooks implementation

* MatchingEngine interface with OrderMactchingEngine implementation

* Strategy Pattern is used in the validation module.
  Each validation rule (country, amount limit, price/quantity validation) is implemented in a separate class.
  OrderValidator orchestrates these validation strategies, allowing new validation rules to be added without modifying core engine logic.


Why?
----
* You want to switch algorithms at runtime

(E.g., different sorting/logging/discount/payment methods)

* Strategy allows multiple interchangeable behaviors.

* You can avoid code duplication

* You want open-closed principle
New algorithms = new classes
No change to existing logic.

* You can plug in different matching algorithms or order book logic without changing core code.

* Example
MatchingEngine engine = new OrderMatchingEngine();
in future we can add MatchingEngine = new ProMatchingEngine(); like this You can swap it with another engine implementation anytime.


Factory Pattern:
----------------

* Factory Pattern is a creational design pattern that provides a way to create objects without exposing the creation logic to the client 
and refers to the newly created object through a common interface.

* In my Trading Engine POC, I used the Factory Pattern in two places:
(1) A factory-like behavior inside the TradeType enum which constructs the correct trade configuration (like maxAmount).
(2) The OrderMatchingEngine constructor acts as a factory by automatically creating the correct OrderBook instances for each TradeType.
This ensures object creation is centralized, flexible, and hidden from the client code.

 why?
------
* Centralized Object Creation

* Abstraction via Interface

* Easy Extension / Maintenance

* This reduces coupling and improves maintainability.

* Separation of Concerns


 Summary:
----------

Hides concrete implementation details.

Centralizes creation logic.

Works through a common interface, allowing easy extension.

------------------------------------------------------------------------------------------------------

3)CONCURRENCY APPROACH
========================

 **Non-blocking order submission**
submitOrder()` returns immediately                      
Main thread never waits → 1000s of orders/sec 

**4 dedicated background matcher threads**
Executors.newFixedThreadPool(4) + matcherPool.submit()` 
Real parallel matching 
 
**Thread-safe order books**           
PriorityBlockingQueue + synchronized addOrder()`      
Zero race conditions 

**Thread-safe trade execution**

 **Thread-safe trade recording**       
 TradeExecutor.execute() is synchronized`              
 No corrupted trade list 

**True concurrency proof**             
Mixed console output (TRADE + REJECTED interleaved)       
  
**Graceful shutdown**
---------------------------------------------------------------------------------------------------------------------------------

4)ANY ASSUMPTIONS MADE
============================

1. CSV Input Format Is Strict

 -> Order fields must follow a fixed order:
 -> orderId,traderId,tradeType,orderType,price,quantity,countryCode,timestamp

2. Country Codes Must Be One of:

 ->US, UK, IN, SG, JP, DE, FR
 ->Anything else throws InvalidCountryException.

3. Order Amount Limits

-> Based on asset type:
 TradeType	Max Amount
  EQUITY	100,000
  FOREX	500,000
  CRYPTO	50,000
-> Violation → AmountLimitViolationException

4. Duplicate Order IDs Not Allowed

 -> If seen again → DuplicateOrderException

5. Matching Logic Assumption
   -> Matching is Price-Time Priority:
   ->Best price first
   ->If price ties → earliest timestamp first


