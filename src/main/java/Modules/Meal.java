package Modules;

public class Meal {
    private String name;
    private String description;
    private double cost;

    public Meal(String name, String description, double cost) {
        this.name = name;
        if(description == null)
            this.description = "";
        else
            this.description = description;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%-20s %.2f zł\n%-20s", name, cost, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        return Double.compare(meal.cost, cost) == 0 &&
                (name != null ? name.equals(meal.name) : meal.name == null)
                && (description != null ? description.equals(meal.description) : meal.description == null);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


}