package GUI.views;

import GUI.other.Translator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AddOrDeleteCategoryView extends Scene{
    private Translator translator;
    private BorderPane pane;
    private ListView categoryList;
    private Label name;
    private TextField category;
    private Button add;
    private Button back;
    private Button delete;

    public AddOrDeleteCategoryView(Translator translator) {
        super(new BorderPane(),800,500);
        pane = (BorderPane) this.getRoot();
        this.translator = translator;
        setUpPane();
    }

    public Button getDelete() {
        return delete;
    }

    public Button getAdd() {
        return add;
    }

    public Button getBack() {
        return back;
    }

    public ListView getCategoryList() {
        return categoryList;
    }

    public TextField getCategory() {
        return category;
    }

    private void setUpPane(){
        HBox field = new HBox(10);
        HBox buttonBox = new HBox(10);
        VBox leftSide = new VBox(10);
        category = new TextField();
        add = new Button(translator.getTranslation("add"));
        back = new Button(translator.getTranslation("views.back"));
        setUpLabel();
        field.setAlignment(Pos.CENTER_LEFT);
        field.getChildren().addAll(name,category);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().addAll(back,add);
        leftSide.setAlignment(Pos.CENTER_LEFT);
        leftSide.getChildren().addAll(field,buttonBox);
        pane.setLeft(leftSide);
        pane.setCenter(setUpCategoryPane());
        pane.setBackground(new Background(getBackgroundImage()));
    }

    private GridPane setUpCategoryPane(){
        GridPane categoryPane = new GridPane();
        delete = new Button(translator.getTranslation("delete"));
        categoryList = new ListView();
        categoryList.setPrefSize(300,200);
        categoryPane.setPadding(new Insets(10,10,10,10));
        categoryPane.setAlignment(Pos.CENTER);
        categoryPane.add(categoryList,0,0);
        categoryPane.add(delete,0,1);
        return categoryPane;
    }

    private void setUpLabel(){
        name = new Label(translator.getTranslation("name"));
        name.setTextFill(Color.WHITE);
        name.setFont(Font.font("Arial", FontWeight.BOLD,15));
    }

    private BackgroundImage getBackgroundImage() {
        Image d = new Image(getClass().getResource("/files/addmeal.jpg").toExternalForm(),
                1200, 500, true, true);
        return new BackgroundImage(d,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }
}

