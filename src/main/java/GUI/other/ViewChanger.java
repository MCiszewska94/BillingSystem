package GUI.other;

import GUI.views.*;
import javafx.stage.Stage;

public class ViewChanger {
    private Stage primaryStage;
    private ActionView actionView;
    private OrderView orderView;
    private SummaryView summaryView;
    private AdministrationView administrationView;
    private AdministrationActionView administrationActionView;
    private AddOrDeleteMealView addOrDeleteMealView;
    private AddOrDeleteCategoryView addOrDeleteCategoryView;

    public ViewChanger(Stage primaryStage,
                       ActionView actionView,
                       OrderView orderView,
                       SummaryView summaryView,
                       AdministrationView administrationView,
                       AdministrationActionView administrationActionView,
                       AddOrDeleteMealView addOrDeleteMealView,
                       AddOrDeleteCategoryView addOrDeleteCategoryView)
    {
        this.primaryStage = primaryStage;
        this.actionView = actionView;
        this.orderView = orderView;
        this.summaryView = summaryView;
        this.administrationView = administrationView;
        this.administrationActionView = administrationActionView;
        this.addOrDeleteMealView = addOrDeleteMealView;
        this.addOrDeleteCategoryView = addOrDeleteCategoryView;
    }


    public void goToActionView(){primaryStage.setScene(actionView);}

    public void goToOrderView() {
        primaryStage.setScene(orderView);
    }

    public void goToSummaryView(){
        primaryStage.setScene(summaryView);
    }

    public void goToAdministrationView() {
        primaryStage.setScene(administrationView);
    }

    public void goToAdministrationActionView() {
        primaryStage.setScene(administrationActionView);
    }

    public void goToAddOrDeleteMealView(){
        primaryStage.setScene(addOrDeleteMealView);
    }


    public void goToAddOrDeleteCategoryView() {
        primaryStage.setScene(addOrDeleteCategoryView);
    }
}
