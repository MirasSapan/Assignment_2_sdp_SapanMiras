# Clean Code principles applied

Five principles, each with a short excerpt from this codebase.

## 1. Meaningful, intention-revealing names

**Before** (the kind of naming this codebase deliberately avoids):

```java
public class MF2 {
    public Object create(String n, int c) { ... }
}
```

**After** — actual code, `VeganMealFactory` / `KetoMealFactory`:

```java
public class VeganMealFactory extends MealFactory {
    @Override
    protected Meal createMeal(String name, int calories) {
        return new VeganMeal(name, calories);
    }
}
```

The class name says which diet it builds, `createMeal` says what it does,
and the parameters are `name`/`calories`, not `n`/`c`. No comment is needed
to explain what this class is for.

## 2. Small methods, each doing one thing

**Before** (what a naive Factory Method implementation tends to look like —
creation, side effects, and logging all mixed into one method):

```java
public Meal prepareMeal(String name, int calories) {
    Meal meal = name.equals("vegan")
            ? new VeganMeal(name, calories)
            : new KetoMeal(name, calories);
    System.out.println("Packing: " + meal.getDescription());
    return meal;
}
```

**After** — actual code, `MealFactory`:

```java
public final Meal prepareMeal(String name, int calories) {
    Meal meal = createMeal(name, calories);
    packMeal(meal);
    return meal;
}

private void packMeal(Meal meal) {
    System.out.println("Packing: " + meal.getDescription());
}
```

`prepareMeal` only orchestrates two steps; `createMeal` (implemented by each
subclass) only builds; `packMeal` only logs. Each method has exactly one
reason to change.

## 3. No magic numbers/strings

**Before** (selecting a family by typing a literal string — a typo like
`"asain"` compiles fine and fails silently at runtime):

```java
CuisineFactory factory = cuisine.equals("asian")
        ? new AsianCuisineFactory()
        : new MediterraneanCuisineFactory();
```

**After** — actual code, `CuisineType` + `CuisineFactoryProvider`:

```java
public enum CuisineType { ASIAN, MEDITERRANEAN }

public static CuisineFactory factoryFor(CuisineType type) {
    return switch (type) {
        case ASIAN -> new AsianCuisineFactory();
        case MEDITERRANEAN -> new MediterraneanCuisineFactory();
    };
}
```

The set of valid cuisines is now a closed, compiler-checked enum instead of
free-form strings scattered through the codebase.

## 4. Validated construction (build() throws a clear exception on invalid state)

**Before** (an inconsistent object can be created and only fails later,
far from the real cause):

```java
MealKit kit = new MealKit(asianMainDish, mediterraneanSideDish); // silently wrong
```

**After** — actual code, `MealKitBuilder.build()`:

```java
public MealKit build() {
    if (mainDish == null || sideDish == null) {
        throw new IllegalStateException(
                "A MealKit requires both a main dish and a side dish");
    }
    if (!mainDish.getCuisine().equals(sideDish.getCuisine())) {
        throw new IllegalStateException(
                "Cuisine mismatch: main dish is " + mainDish.getCuisine()
                        + " but side dish is " + sideDish.getCuisine());
    }
    return new MealKit(mainDish, sideDish);
}
```

Every `Meal` is protected the same way: `AbstractMeal`'s constructor
rejects a blank name or non-positive calorie count immediately, with a
message that names exactly what was wrong.

## 5. Consistent formatting, small, focused classes

**Before** (a single class doing everything a whole pattern needs —
products, factories and ordering logic all in one place):

```java
public class MealKitService {
    // creates dishes, builds kits, validates them, AND runs the order —
    // one class, four responsibilities, hard to extend or test in isolation
}
```

**After** — actual code: the same responsibilities are split across seven
small, single-purpose classes: `MainDish`/`SideDish` (contracts),
`AsianMainDish`/`AsianSideDish`/`MediterraneanMainDish`/`MediterraneanSideDish`
(data), `CuisineFactory` (contract), `AsianCuisineFactory`/
`MediterraneanCuisineFactory` (creation), `MealKitBuilder` (validated
assembly), and `MealKitOrderService` (orchestration only). Adding a third
cuisine means adding new files, not editing existing ones — each class
stays short and formatted consistently (same brace style, same field-then-
constructor-then-methods layout throughout the project).
