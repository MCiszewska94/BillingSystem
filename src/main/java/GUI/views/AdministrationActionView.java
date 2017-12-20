package GUI.views;

import GUI.other.Translator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AdministrationActionView extends Scene {
    private Translator translator;
    private VBox vbox;
    private Button addDeleteCateogory;
    private Button addDeleteMeal;
    private Button back;
    private Label choose;

    public AdministrationActionView(Translator translator) {
        super(new VBox(10),800,500);
        vbox = (VBox)this.getRoot();
        this.translator = translator;
        setUpVBox();
    }

    public Button getBack() {
        return back;
    }

    public Button getAddDeleteCateogory() {
        return addDeleteCateogory;
    }

    public Button getAddDeleteMeal() {
        return addDeleteMeal;
    }

    private void setUpVBox() {
        choose = new Label();
        choose.setFont(Font.font("Arial", FontWeight.BOLD,21));
        choose.setTextFill(Color.WHITE);
        choose.setText(translator.getTranslation("administration.choose"));
        addDeleteCateogory = setUpButton("addOrDeleteCategory");
        addDeleteMeal = setUpButton("addOrDeleteMeal");
        back = setUpButton("views.back");
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(choose, addDeleteCateogory, addDeleteMeal,back);
        vbox.setBackground(new Background(getBackgroundImage()));
    }

    private Button setUpButton(String name){
        Button returned = new Button(translator.getTranslation(name));
        returned.setPrefSize(200,50);
        return returned;
    }

    private BackgroundImage getBackgroundImage(){
        Image d = new Image(getClass().getResource("/files/administrationactionview.jpg").toExternalForm(),
                1200, 500, true, true);
        return new BackgroundImage(d,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }


}
