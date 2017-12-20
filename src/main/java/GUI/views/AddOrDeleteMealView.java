package GUI.views;

import GUI.other.Translator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AddOrDeleteMealView extends Scene {
    private Translator translator;
    private BorderPane addMealPane;
    private Alert message;
    private TextField name;
    private TextField description;
    private TextField cost;
    private ChoiceBox categories;
    private Button add;
    private Button back;
    private ListView mealList;
    private Button delete;

    public AddOrDeleteMealView(Translator translator) {
        super(new BorderPane(), 800, 500);
        addMealPane = (BorderPane) this.getRoot();
        this.translator = translator;
        setUpBorderPane();
    }

    public Button getDelete() {
        return delete;
    }

    public TextField getName() {
        return name;
    }

    public TextField getDescription() {
        return description;
    }

    public TextField getCost() {
        return cost;
    }

    public ChoiceBox getCategories() {
        return categories;
    }

    public Button getAdd() {
        return add;
    }

    public ListView getMealList() {
        return mealList;
    }

    public Button getBack() {
        return back;
    }

    private void setUpBorderPane() {
        HBox nameLabelAndField = new HBox(10);
        HBox descriptionLabelAndField = new HBox(26);
        HBox costLabelAndField = new HBox(20);
        HBox buttons = new HBox(10);
        VBox fields = new VBox(10);
        add = new Button(translator.getTranslation("add"));
        back = new Button(translator.getTranslation("views.back"));

        Label nameLabel = setUpLabel("name");
        Label descriptionLabel = setUpLabel("description");
        Label costLabel = setUpLabel("cost");
        name = new TextField();
        description = new TextField();
        cost = new TextField();
        nameLabelAndField.setAlignment(Pos.CENTER);
        descriptionLabelAndField.setAlignment(Pos.CENTER);
        costLabelAndField.setAlignment(Pos.CENTER);
        fields.setAlignment(Pos.CENTER);
        nameLabelAndField.getChildren().addAll(nameLabel, name);
        descriptionLabelAndField.getChildren().addAll(descriptionLabel, description);
        costLabelAndField.getChildren().addAll(costLabel, cost);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(back,add);
        fields.getChildren().addAll(nameLabelAndField, descriptionLabelAndField, costLabelAndField,buttons);
        addMealPane.setLeft(fields);
        addMealPane.setCenter(setUpRightSideOfPane());
        addMealPane.setBackground(new Background(getBackgroundImage()));
    }

    private GridPane setUpRightSideOfPane(){
        GridPane gridPane = new GridPane();
        categories = new ChoiceBox();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setAlignment(Pos.CENTER);
        delete = new Button(translator.getTranslation("delete"));
        mealList = new ListView();
        mealList.setPrefSize(300,200);
        gridPane.add(categories,0,0);
        gridPane.add(mealList,0,1);
        gridPane.add(delete,0,2);
        return gridPane;
    }


    private Label setUpLabel(String name) {
        Label total = new Label(translator.getTranslation(name));
        total.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        total.setTextFill(Color.WHITE);
        return total;
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

    public void showBadMessage() {
        message = new Alert(Alert.AlertType.ERROR);
        message.setTitle("Error Dialog");
        message.setContentText(translator.getTranslation("addMeal.badmessage"));
        message.showAndWait();
    }

}
