package GUI;

import GUI.other.Translator;
import GUI.other.ViewChanger;
import GUI.presenters.*;
import GUI.views.*;
import javafx.application.Application;

import javafx.stage.Stage;

import java.util.Locale;


public class MainApplication extends Application {
    private Stage primaryStage;
    private Translator translator;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.translator = new Translator();
        LanguageChoiceView languageChoiceView = new LanguageChoiceView();
        LanguageChoicePresenter languageChoicePresenter = new LanguageChoicePresenter(languageChoiceView,this);
        primaryStage.setScene(languageChoiceView);
        primaryStage.show();
    }

    public void initApp(Locale locale){
        translator.setLocale(locale);
        OrderView orderView = new OrderView(translator);
        AdministrationView administrationView = new AdministrationView(translator);
        ActionView actionView = new ActionView(translator);
        SummaryView  summaryView = new SummaryView(translator);
        AdministrationActionView administrationActionView = new AdministrationActionView(translator);
        AddOrDeleteMealView addOrDeleteMealView = new AddOrDeleteMealView(translator);
        AddOrDeleteCategoryView addOrDeleteCategoryView = new AddOrDeleteCategoryView(translator);
        ViewChanger viewChanger = new ViewChanger(primaryStage,actionView,
                orderView, summaryView, administrationView,administrationActionView, addOrDeleteMealView,addOrDeleteCategoryView);
        ActionViewPresenter actionViewPresenter = new ActionViewPresenter(actionView,viewChanger);
        AdministrationViewPresenter administrationViewPresenter = new AdministrationViewPresenter(administrationView,viewChanger);
        OrderViewPresenter orderViewPresenter = new OrderViewPresenter(orderView,viewChanger, translator);
        AdministrationActionViewPresenter administrationActionViewPresenter =
                new AdministrationActionViewPresenter(administrationActionView,viewChanger);
        AddOrDeleteMealViewPresenter addOrDeleteMealViewPresenter =
                new AddOrDeleteMealViewPresenter(addOrDeleteMealView,viewChanger,translator);
        AddOrDeleteCategoryViewPresenter addOrDeleteCategoryViewPresenter =
                new AddOrDeleteCategoryViewPresenter(addOrDeleteCategoryView,viewChanger,translator);
        SummaryViewPresenter summaryViewPresenter =
                new SummaryViewPresenter(summaryView,translator,orderViewPresenter,viewChanger);
        viewChanger.goToActionView();
    }

}
