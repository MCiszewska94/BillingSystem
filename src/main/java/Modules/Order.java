package Modules;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Meal> order;

    public Order(List<Meal> order) {
        this.order = order;
    }

    public Order(){
        this.order = new ArrayList<>();
    }

    public List<Meal> getMeals() {
        return order;
    }

    public void addMeal(Meal meal) {
        order.add(meal);
    }

    public void deleteMeal(Meal meal){
        order.remove(meal);
    }

    public double getTotal(){
        double total = 0;
        for(Meal meal : order)
            total += meal.getCost();
        return total;
    }



}
