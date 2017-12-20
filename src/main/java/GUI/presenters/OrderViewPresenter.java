package GUI.presenters;

import GUI.other.Translator;
import GUI.other.ViewChanger;
import GUI.views.OrderView;
import JDBC.CategoryDao;
import JDBC.MenuDao;
import Modules.Meal;
import Modules.Order;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OrderViewPresenter {
    private OrderView orderView;
    private ViewChanger viewChanger;
    private Translator translator;
    private List<Meal> meals = new ArrayList<>();
    private Order order = new Order(meals);

    public OrderViewPresenter(OrderView orderView, ViewChanger viewChanger, Translator translator) {
        this.orderView = orderView;
        this.viewChanger = viewChanger;
        this.translator = translator;
        attachButtonListeners();
        attachCategories();
        attachSelectedCategory();
    }

    private void attachButtonListeners() {
        orderView.getAdd().setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                meals.add((Meal) orderView.getMenuList().getSelectionModel().getSelectedItem());
                orderView.getOrderList().setItems(FXCollections.observableArrayList(order.getMeals()));
            }
        });

        orderView.getPrevious().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ObservableList list = FXCollections.observableArrayList(order.getMeals());
                list.clear();
                orderView.getOrderList().setItems(list);
                viewChanger.goToActionView();
            }
        });

        orderView.getDelete().setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                meals.remove(orderView.getOrderList().getSelectionModel().getSelectedItem());
                orderView.getOrderList().setItems(FXCollections.observableArrayList(order.getMeals()));
            }
        });

        orderView.getNext().setOnAction(e -> viewChanger.goToSummaryView());

    }

    private void attachCategories() {
        CategoryDao categoryDao = new CategoryDao();
        orderView.getCategories().
                setItems(FXCollections.
                        observableArrayList(categoryDao.
                                getCategoriesWithGivenLanguage(translator.
                                        getLocale())));
    }

    private void attachSelectedCategory() {
        orderView.getCategories().getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                MenuDao menuDao = new MenuDao();
                orderView.getMenuList().setItems(FXCollections.observableArrayList(menuDao.
                        getMealsFromGivenCategoryAndLanguage((String) orderView.getCategories().getSelectionModel().getSelectedItem(), translator.getLocale())));

            }
        });
    }


    public ListView getOrderList() {
        return orderView.getOrderList();
    }

    public double getTotal(){
        return order.getTotal();
    }
}
