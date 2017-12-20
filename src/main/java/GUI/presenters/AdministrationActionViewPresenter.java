package GUI.presenters;

import GUI.other.ViewChanger;
import GUI.views.AdministrationActionView;

public class AdministrationActionViewPresenter {
    AdministrationActionView administrationActionView;
    ViewChanger viewChanger;

    public AdministrationActionViewPresenter(AdministrationActionView administrationActionView, ViewChanger viewChanger) {
        this.administrationActionView = administrationActionView;
        this.viewChanger = viewChanger;
        attachButtonListeners();
    }

    private void attachButtonListeners(){
        administrationActionView.getAddDeleteCateogory().setOnAction(e -> viewChanger.goToAddOrDeleteCategoryView());
        administrationActionView.getAddDeleteMeal().setOnAction(e -> viewChanger.goToAddOrDeleteMealView());
        administrationActionView.getBack().setOnAction(e -> viewChanger.goToAdministrationView());
    }

}
