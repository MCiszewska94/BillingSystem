package GUI.views;

import GUI.other.Translator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ActionView extends Scene {
    private Translator translator;
    private HBox actionScene;
    private Button order;
    private Button administration;

    public ActionView(Translator translator) {
        super(new HBox(), 800, 500);
        actionScene = (HBox) this.getRoot();
        this.translator = translator;
        setUpHBox();
    }

    public Button getOrderButton() {
        return order;
    }

    public Button getAdministrationButton() {
        return administration;
    }

    private void setUpHBox() {
        Image d = new Image(getClass().getResource("/files/d.jpg").toExternalForm(),
                1200, 500, true, true);
        BackgroundImage bg = new BackgroundImage(d,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        actionScene.setAlignment(Pos.CENTER);
        order = new Button(translator.getTranslation("actionView.order"));
        administration = new Button(translator.getTranslation("actionView.administration"));
        order.setPrefSize(150, 50);
        administration.setPrefSize(150, 50);
        actionScene.setBackground(new Background(bg));
        actionScene.getChildren().addAll(order, administration);
    }

}
