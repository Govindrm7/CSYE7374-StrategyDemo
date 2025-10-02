# Strategy Pattern Discount Engine

Maven-based Java 11 sample that demonstrates the Strategy design pattern through a configurable discount engine. The project is a lab exercise for Northeastern University's CSYE7374 Design Patterns course and emphasizes clean encapsulation, contract-driven development, and runtime flexibility.

## Project Structure
- `pom.xml` Maven descriptor configuring Java 11 compilation.
- `src/main/java/edu/neu/csye7374`
  - `Driver` bootstraps the console demo.
  - `DiscountDemo` builds sample strategies and showcases live swapping.
  - `DiscountProcessor` holds the active strategy and applies it to prices.
  - `DiscountStrategy` interface defining the discount contract.
  - Concrete strategies:
    - `NoDiscountStrategy`
    - `PercentageDiscountStrategy`
    - `FlatAmountDiscountStrategy`
    - `BulkPurchaseDiscountStrategy`

## Class-by-Class Breakdown
- `DiscountStrategy`: Defines `applyDiscount(double)` and `getName()`; acts as the abstraction that all clients depend on.
- `DiscountProcessor`: Context object that stores a `DiscountStrategy`, enforces non-null strategies, and delegates price computation. Setter enables runtime strategy substitution.
- `NoDiscountStrategy`: Baseline implementation returning the original price unchanged.
- `PercentageDiscountStrategy`: Applies a percentage markdown, rejecting invalid percentages and negative prices.
- `FlatAmountDiscountStrategy`: Subtracts a fixed amount while guarding against negative inputs and preventing negative outputs via `Math.max`.
- `BulkPurchaseDiscountStrategy`: Discounts only when the original price meets a monetary threshold; validates threshold and percentage bounds.
- `DiscountDemo`: Creates an example order, instantiates each strategy, and iterates through them using a shared `DiscountProcessor` to demonstrate runtime polymorphism.
- `Driver`: Contains `main`, prints banners, and invokes the demo to make the lab runnable via the command line.

## Design Patterns and Principles
- **Strategy Pattern (GoF Behavioral)**: `DiscountStrategy` defines the family of algorithms; concrete strategies encapsulate their own logic; `DiscountProcessor` selects algorithms dynamically.
- **Programming to an Interface**: Clients interact with `DiscountStrategy` instead of concrete types, enabling substitution.
- **Single Responsibility Principle**: Each class has a focused purpose (strategy logic, orchestration, demo).
- **Open/Closed Principle**: New discount policies can be added by composing new strategy implementations without modifying existing classes.
- **Fail-Fast Validation**: Constructors throw `IllegalArgumentException` on invalid input, preventing illegal state.
- **Immutability of Parameters**: Strategy configuration fields are `final`, ensuring thread-safe, predictable behavior.
- **Separation of Concerns**: Demo code lives outside business logic; pricing logic is isolated from presentation.

## Technical Highlights
- Uses standard Java collections (`List`, `Arrays.asList`) to maintain strategy sets.
- Employs formatted console output (`System.out.printf`) for readable reporting.
- Guard clauses protect against negative prices and invalid discount parameters across strategies.
- Context (`DiscountProcessor`) exposes getter/setter enabling integration tests or UI layers to inspect and change policies.

## Build and Run
1. Install Java 11+ and Apache Maven, ensuring both are available on your PATH.
2. Compile and package the project:
   ```bash
   mvn clean package
   ```
3. Execute the demo using the produced jar:
   ```bash
   java -cp target/CSYE7374-Design-Patterns-1.0-SNAPSHOT.jar edu.neu.csye7374.Driver
   ```

### Expected Console Output
```
============Main Execution Start===================

Original price: $250.00

Strategy: No Discount              -> Final price: $250.00
Strategy: 15% Off                  -> Final price: $212.50
Strategy: $30.00 Off               -> Final price: $220.00
Strategy: Bulk 20% Off over $200   -> Final price: $200.00

============Main Execution End===================
```

## Extending the Lab
- Implement new strategies (e.g., loyalty points, tiered percentage discount) by adding classes that implement `DiscountStrategy`.
- Chain multiple strategies through a composite context for complex pricing rules.
- Add parameterized unit tests with JUnit to exercise edge cases (negative input, boundary thresholds).
- Extract strategy registration to a configuration file or dependency injection container for production scenarios.

## License
Released under the MIT License. See `LICENSE` for details.
