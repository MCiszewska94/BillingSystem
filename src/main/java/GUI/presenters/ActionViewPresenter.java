package GUI.presenters;

import GUI.other.ViewChanger;
import GUI.views.ActionView;

public class ActionViewPresenter {

    private ActionView actionView;
    private ViewChanger viewChanger;

    public ActionViewPresenter(ActionView actionView, ViewChanger viewChanger) {
        this.actionView = actionView;
        this.viewChanger = viewChanger;
        attachButtonListeners();
    }

    private void attachButtonListeners() {
        actionView.getOrderButton().setOnAction(e -> viewChanger.goToOrderView());
        actionView.getAdministrationButton().setOnAction(e -> viewChanger.goToAdministrationView());
    }

}
