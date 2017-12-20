package GUI.presenters;

import GUI.other.Translator;
import GUI.other.ViewChanger;
import GUI.views.AddOrDeleteMealView;
import JDBC.CategoryDao;
import JDBC.MenuDao;
import Modules.Meal;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AddOrDeleteMealViewPresenter {
    private AddOrDeleteMealView addOrDeleteMealView;
    private ViewChanger viewChanger;
    private Translator translator;

    public AddOrDeleteMealViewPresenter(AddOrDeleteMealView addOrDeleteMealView, ViewChanger viewChanger, Translator translator) {
        this.addOrDeleteMealView = addOrDeleteMealView;
        this.viewChanger = viewChanger;
        this.translator = translator;
        attachCategories();
        attachSelectedCategory();
        attachButtonListeners();
    }

    private void attachButtonListeners() {
        MenuDao menuDao = new MenuDao();
        CategoryDao categoryDao = new CategoryDao();
        addOrDeleteMealView.getAdd().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String category = (String) addOrDeleteMealView.getCategories().getSelectionModel().getSelectedItem();
                String name = addOrDeleteMealView.getName().getText();
                double cost = Double.parseDouble(addOrDeleteMealView.getCost().getText());
                String lang = translator.getLocale();
                try {
                    String description = addOrDeleteMealView.getDescription().getText();
                    if(description.equals(""))
                        menuDao.addMeal(category, name, null, cost, lang);
                    else
                        menuDao.addMeal(category,name,description,cost,lang);
                    refreshMealList();
                } catch (Exception e) {
                    addOrDeleteMealView.showBadMessage();
                }
            }
        });
        addOrDeleteMealView.getDelete().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Meal selectedMeal = (Meal) addOrDeleteMealView.getMealList().getSelectionModel().getSelectedItem();
                String category = (String) addOrDeleteMealView.getCategories().getSelectionModel().getSelectedItem();
                new MenuDao().deleteMeal(category,selectedMeal.getName());
                refreshMealList();
            }
        });
        addOrDeleteMealView.getBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addOrDeleteMealView.getName().clear();
                addOrDeleteMealView.getDescription().clear();
                addOrDeleteMealView.getCost().clear();
                viewChanger.goToAdministrationActionView();
            }
        });


    }

    private void attachCategories() {
        CategoryDao categoryDao = new CategoryDao();
        addOrDeleteMealView.getCategories().setItems(FXCollections.observableArrayList(
                categoryDao.getCategoriesWithGivenLanguage(translator.getLocale())));
    }

    private void attachSelectedCategory(){
        addOrDeleteMealView.getCategories().getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                MenuDao menuDao = new MenuDao();
                addOrDeleteMealView.getMealList().setItems(FXCollections.observableArrayList(menuDao.
                        getMealsFromGivenCategoryAndLanguage((String) addOrDeleteMealView.getCategories().getSelectionModel().getSelectedItem(),translator.getLocale())));

            }
        });
    }

    private void refreshMealList(){
        MenuDao menuDao = new MenuDao();
        addOrDeleteMealView.getMealList().setItems(FXCollections.observableArrayList(menuDao.
                getMealsFromGivenCategoryAndLanguage((String) addOrDeleteMealView.getCategories().getSelectionModel().getSelectedItem(),translator.getLocale())));
    }
}
