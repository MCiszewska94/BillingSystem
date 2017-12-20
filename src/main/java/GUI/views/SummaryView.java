package GUI.views;

import GUI.other.Translator;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Optional;


public class SummaryView extends Scene {
    private Translator translator;
    private GridPane summaryPane;
    private ListView order;
    private Label summary;
    private Alert dialog;
    private Button end;


    public SummaryView(Translator translator) {
        super(new GridPane(), 800, 500);
        summaryPane = (GridPane) this.getRoot();
        this.translator = translator;
        setUpSummaryPane();
    }

    public ListView getOrder() {
        return order;
    }

    public Button getEnd() {
        return end;
    }

    private void setUpSummaryPane() {
        summaryPane.setPadding(new Insets(10, 10, 10, 10));
        summary = setUpSummaryLabel("summary");
        order = new ListView();
        order.setPrefSize(300, 200);
        end = new Button(translator.getTranslation("end"));
        summaryPane.setAlignment(Pos.CENTER);
        summaryPane.add(summary, 0, 0);
        summaryPane.add(order, 0, 1);
        summaryPane.add(end, 0, 3);
        summaryPane.setBackground(new Background(getBackgroundImage()));

    }

    private Label setUpSummaryLabel(String name) {
        Label label = new Label(translator.getTranslation(name));
        label.setFont(Font.font("Arial", FontWeight.BOLD, 21));
        label.setTextFill(Color.WHITE);
        label.setAlignment(Pos.CENTER);
        return label;
    }

    public void showDialog() {
        dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle(translator.getTranslation("summary"));
        dialog.setHeaderText(null);
        dialog.setContentText(translator.getTranslation("orderPreparation"));
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK)
            Platform.exit();
    }

    private BackgroundImage getBackgroundImage(){
        Image d = new Image(getClass().getResource("/files/summary.jpg").toExternalForm(),
                1200, 500, true, true);
        return new BackgroundImage(d,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }
}
