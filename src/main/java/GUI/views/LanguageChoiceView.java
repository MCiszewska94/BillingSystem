package GUI.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LanguageChoiceView extends Scene {
    private GridPane gridPane;
    private Button polishLanguageButton;
    private Button englishLanguageButton;

    public LanguageChoiceView() {
        super(new GridPane(), 800, 500);
        gridPane = (GridPane) this.getRoot();
        setUpGridPane();
    }

    public Button getPolishLanguageButton() {
        return polishLanguageButton;
    }

    public Button getEnglishLanguageButton() {
        return englishLanguageButton;
    }

    private void setUpGridPane() {
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(getLabel(), 0, 0);
        gridPane.add(getHBox(), 0, 3);
        Image rest = new Image(getClass().getResource("/files/c.jpg").toExternalForm(),
                1200, 500, true, true);
        BackgroundImage bg = new BackgroundImage(rest,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        gridPane.setBackground(new Background(bg));
    }

    private Label getLabel() {
        Label label = new Label("Wybierz język/Choose your language");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        label.setTextFill(Color.WHITE);
        label.setAlignment(Pos.BASELINE_CENTER);
        return label;
    }

    private HBox getHBox() {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        polishLanguageButton = new Button();
        englishLanguageButton = new Button();
        polishLanguageButton.setPrefSize(120, 100);
        englishLanguageButton.setPrefSize(120, 100);

        Image polishImage = new Image(getClass().getResource("/files/pl.jpg").toExternalForm(),
                100, 120, true, true);
        polishLanguageButton.setBackground(new Background(new BackgroundImage(polishImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
        Image enImage = new Image(getClass().getResource("/files/en.png").toExternalForm(),
                100, 120, true, true);
        englishLanguageButton.setBackground(new Background(new BackgroundImage(enImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(polishLanguageButton, englishLanguageButton);
        return hBox;
    }

}
