package Modules;

import java.util.List;

public class Category {
    private String name;
    private List<Meal> meals;

    public Category(String name, List<Meal> meals) {
        this.name = name;
        this.meals = meals;
    }


    public String getName() {
        return name;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return (name != null ? name.equals(category.name) : category.name == null)
                && (meals != null ? meals.equals(category.meals) : category.meals == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (meals != null ? meals.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s",name,meals);
    }
}
