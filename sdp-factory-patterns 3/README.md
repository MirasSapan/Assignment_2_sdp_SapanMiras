# SDP Assignment 2 — Factory Method & Abstract Factory

**Domain:** Meal-kit ordering service.

Part A shows a single product line (a `Meal`) built with **Factory Method**.
Part B extends the same domain into full **Abstract Factory**: instead of one
product, a `CuisineFactory` produces a *consistent family* of two related
products (a `MainDish` and a `SideDish`) that always belong to the same
cuisine, so a client can never accidentally mix an Asian main dish with a
Mediterranean side dish.

## Structure and requirement mapping

### Part A — Factory Method (`factorymethod` package)

| Requirement | Class |
|---|---|
| Product | `Meal` (interface) |
| Concrete Product | `VeganMeal`, `KetoMeal` |
| Creator | `MealFactory` (abstract, also a template method `prepareMeal`) |
| Concrete Creator | `VeganMealFactory`, `KetoMealFactory` |

### Part B — Abstract Factory (`abstractfactory` package)

| Requirement | Class |
|---|---|
| Abstract Products | `MainDish`, `SideDish` |
| Concrete Products | `AsianMainDish`/`AsianSideDish`, `MediterraneanMainDish`/`MediterraneanSideDish` |
| Abstract Factory | `CuisineFactory` |
| Concrete Factories | `AsianCuisineFactory`, `MediterraneanCuisineFactory` |
| Client | `MealKitOrderService` — depends only on `CuisineFactory`, `MainDish`, `SideDish` |

`CuisineFactoryProvider` is the single place allowed to instantiate a
concrete factory class (by `CuisineType`); everything else, including the
client, only ever talks to interfaces. `MealKitBuilder` assembles the two
dishes into an immutable `MealKit` and validates that they belong to the
same cuisine before returning it.

## Clean Code

See [`CLEAN_CODE.md`](./CLEAN_CODE.md) for the five principles applied, each
with a before/after excerpt.

## Build & run

Requires JDK 17+.

```bash
# with Maven
mvn compile
mvn -q exec:java -Dexec.mainClass=com.miras.factorydemo.Main   # or just run the Main class from your IDE

# without Maven
javac -d target/classes $(find src/main/java -name "*.java")
java -cp target/classes com.miras.factorydemo.Main
```

Expected output demonstrates: two meals built via Factory Method, two
regionally-consistent meal kits built via Abstract Factory, and a rejected
invalid meal proving the validated-construction guard works.

## Commit history

The repository history is intentionally incremental:
1. Part A — Factory Method implementation
2. Part B — Abstract Factory implementation
3. Documentation (README + Clean Code write-up)
