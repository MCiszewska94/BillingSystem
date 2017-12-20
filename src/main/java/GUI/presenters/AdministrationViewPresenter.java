package GUI.presenters;

import GUI.other.ViewChanger;
import GUI.views.AdministrationView;

public class AdministrationViewPresenter {
    private AdministrationView administrationView;
    private ViewChanger viewChanger;

    public AdministrationViewPresenter(AdministrationView administrationView, ViewChanger viewChanger) {
        this.administrationView = administrationView;
        this.viewChanger = viewChanger;
        attachButtonListener();
        attachPasswordFieldListener();
    }

    private void attachButtonListener() {

        administrationView.getBack().setOnAction(e -> {
            administrationView.getPasswordField().clear();
            viewChanger.goToActionView();
        });
    }

    private void attachPasswordFieldListener(){
        administrationView.getPasswordField().setOnAction(e ->{
            if(administrationView.getPasswordField().getText().endsWith("qwerty"))
                viewChanger.goToAdministrationActionView();
            else{
                administrationView.showMessage();
            }
            administrationView.getPasswordField().clear();
        });
    }

}
