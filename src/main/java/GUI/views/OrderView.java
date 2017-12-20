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


public class OrderView extends Scene {
    private Translator translator;
    private BorderPane borderPane;
    private ChoiceBox categories;
    private Label categoryChoose;
    private Button previous;
    private Button add;
    private ListView menuList;
    private ListView orderList;
    private Button next;
    private Label order;
    private Button delete;


    public OrderView(Translator translator) {
        super(new BorderPane(), 800, 500);
        borderPane = (BorderPane) this.getRoot();
        this.translator = translator;
        setUpBorderPane();
    }

    public Button getDelete() {
        return delete;
    }

    public ListView getOrderList() {
        return orderList;
    }

    public Button getAdd() {
        return add;
    }

    public Button getNext() {
        return next;
    }

    public ChoiceBox getCategories() {
        return categories;
    }

    public ListView getMenuList() {
        return menuList;
    }


    public Button getPrevious() {
        return previous;
    }


    private void setUpBorderPane() {

        borderPane.setLeft(setUpLeftSideOfPane());
        borderPane.setCenter(setUpRightSideOfPane());
        borderPane.setBackground(new Background(getBackgroundImage()));
    }


    private GridPane setUpRightSideOfPane(){
        GridPane gridPaneWithOrderList = new GridPane();
        gridPaneWithOrderList.setAlignment(Pos.CENTER);
        gridPaneWithOrderList.setPadding(new Insets(10,10,10,10));
        VBox vBoxWithMenuList = new VBox(38);
        HBox buttonsHBox = new HBox(190);
        buttonsHBox.setAlignment(Pos.BOTTOM_RIGHT);
        vBoxWithMenuList.setAlignment(Pos.CENTER);
        setOrder();
        delete = new Button(translator.getTranslation("delete"));
        next = new Button(translator.getTranslation("next"));
        orderList = new ListView();
        buttonsHBox.getChildren().addAll(delete,next);
        orderList.setPrefSize(300,200);
        vBoxWithMenuList.getChildren().addAll(order,orderList);
        gridPaneWithOrderList.add(vBoxWithMenuList,0,1);
        gridPaneWithOrderList.add(buttonsHBox,0,2);
        return gridPaneWithOrderList;
    }

    private GridPane setUpLeftSideOfPane(){
        GridPane gridPaneWithMenu = new GridPane();
        VBox orderVBox = new VBox(10);
        HBox orderHBox = new HBox(190);
        gridPaneWithMenu.setPadding(new Insets(10, 10, 10, 10));
        categories = new ChoiceBox();
        setCategoryChoose();
        setOrder();
        previous = new Button(translator.getTranslation("views.back"));
        add = new Button(translator.getTranslation("add"));
        menuList = new ListView();
        menuList.setPrefSize(300, 200);
        orderVBox.setAlignment(Pos.TOP_LEFT);
        orderVBox.getChildren().addAll(categoryChoose, categories);
        orderHBox.setAlignment(Pos.BOTTOM_LEFT);
        orderHBox.getChildren().addAll(previous,add);
        gridPaneWithMenu.setAlignment(Pos.CENTER);
        gridPaneWithMenu.add(orderVBox, 0, 0);
        gridPaneWithMenu.add(menuList, 0, 1);
        gridPaneWithMenu.add(orderHBox,0,2);
        return gridPaneWithMenu;
    }


    private void setCategoryChoose(){
        categoryChoose = new Label(translator.getTranslation("chooseCategory"));
        categoryChoose.setTextFill(Color.WHITE);
        categoryChoose.setFont(Font.font("Arial", FontWeight.BOLD,15));
    }

    private void setOrder(){
        order = new Label(translator.getTranslation("list.order"));
        order.setAlignment(Pos.CENTER_RIGHT);
        order.setTextFill(Color.WHITE);
        order.setFont(Font.font("Arial",FontWeight.BOLD,15));
    }

    private BackgroundImage getBackgroundImage(){
        Image d = new Image(getClass().getResource("/files/orderview.jpg").toExternalForm(),
                1200, 500, true, true);
        return new BackgroundImage(d,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }
}
