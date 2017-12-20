package GUI.presenters;

import GUI.other.Translator;
import GUI.other.ViewChanger;
import GUI.views.AddOrDeleteCategoryView;
import JDBC.CategoryDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AddOrDeleteCategoryViewPresenter {
    private AddOrDeleteCategoryView addOrDeleteCategoryView;
    private ViewChanger viewChanger;
    private Translator translator;

    public AddOrDeleteCategoryViewPresenter(AddOrDeleteCategoryView addOrDeleteCategoryView,
                                            ViewChanger viewChanger,
                                            Translator translator) {
        this.addOrDeleteCategoryView = addOrDeleteCategoryView;
        this.viewChanger = viewChanger;
        this.translator = translator;
        attachCategories();
        attachButtonListeners();
    }

    private void attachCategories() {
        CategoryDao categoryDao = new CategoryDao();
        ObservableList list = FXCollections.observableArrayList(
                categoryDao.getCategoriesWithGivenLanguage(translator.getLocale()));
        addOrDeleteCategoryView.getCategoryList().setItems(list);
    }

    private void attachButtonListeners() {
        CategoryDao categoryDao = new CategoryDao();
        addOrDeleteCategoryView.getAdd().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    categoryDao.addCategory(addOrDeleteCategoryView.getCategory().getText(), translator.getLocale());
                    attachCategories();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        addOrDeleteCategoryView.getBack().setOnAction(e ->
        {
            addOrDeleteCategoryView.getCategory().clear();
            viewChanger.goToAdministrationActionView();
        });
        addOrDeleteCategoryView.getDelete().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                categoryDao.deleteCategory((String) addOrDeleteCategoryView.getCategoryList().getSelectionModel().getSelectedItem());
                attachCategories();
            }
        });
    }


}
