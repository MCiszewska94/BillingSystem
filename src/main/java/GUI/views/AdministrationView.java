package GUI.views;

import GUI.other.Translator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class AdministrationView extends Scene{
    private Translator translator;
    private VBox vBox;
    private Label message;
    private Label password;
    private Button back;
    private PasswordField passwordField;

    public Button getBack() {
        return back;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Label getMessage() {
        return message;
    }

    public Label getPassword() {
        return password;
    }

    public AdministrationView(Translator translator) {
        super(new VBox(),800,500);
        vBox = (VBox) this.getRoot();
        this.translator = translator;
        setUpVBox();
    }

    private void setUpVBox(){
        HBox hBox = new HBox(10);
        message = new Label();
        password = new Label(translator.getTranslation("password"));
        password.setFont(Font.font("Arial", FontWeight.BOLD,21));
        password.setTextFill(Color.WHITE);
        passwordField = new PasswordField();
        passwordField.setPromptText("qwerty");
        back = new Button(translator.getTranslation("views.back"));
        hBox.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(password,passwordField);
        vBox.getChildren().addAll(hBox,message,back);
        vBox.setBackground(new Background(getBackgroundImage()));

    }

    public void showMessage(){
        message.setText(translator.getTranslation("administration.message"));
        message.setTextFill(Color.rgb(210, 39, 30));
    }

    private BackgroundImage getBackgroundImage(){
        Image d = new Image(getClass().getResource("/files/administrationview.jpg").toExternalForm(),
                1200, 500, true, true);
        return new BackgroundImage(d,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }


}
