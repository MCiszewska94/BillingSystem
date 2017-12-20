package GUI.presenters;

import GUI.MainApplication;
import GUI.views.LanguageChoiceView;
import javafx.scene.control.Button;

import java.util.Locale;

public class LanguageChoicePresenter {

    private LanguageChoiceView languageChoiceView;
    private MainApplication mainApplication;

    public LanguageChoicePresenter(LanguageChoiceView languageChoiceView, MainApplication mainApplication) {
        this.languageChoiceView = languageChoiceView;
        this.mainApplication = mainApplication;
        attachButtonListeners();
    }

    private void attachButtonListeners() {
        Button polishLanguageButton = languageChoiceView.getPolishLanguageButton();
        Button englishLanguageButton = languageChoiceView.getEnglishLanguageButton();
        polishLanguageButton.setOnAction(e -> mainApplication.initApp(new Locale("pl")));
        englishLanguageButton.setOnAction(e -> mainApplication.initApp(new Locale("en")));
    }

}
