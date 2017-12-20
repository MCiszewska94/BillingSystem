package GUI.presenters;

import GUI.other.Translator;
import GUI.other.ViewChanger;
import GUI.views.SummaryView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SummaryViewPresenter {
    private SummaryView summaryView;
    private OrderViewPresenter orderViewPresenter;
    private Translator translator;
    private ViewChanger viewChanger;

    public SummaryViewPresenter(SummaryView summaryView,
                                Translator translator,
                                OrderViewPresenter orderViewPresenter,
                                ViewChanger viewChanger) {
        this.summaryView = summaryView;
        this.translator = translator;
        this.orderViewPresenter = orderViewPresenter;
        this.viewChanger = viewChanger;
        attachOrder();
        attachButtonListeners();
    }


    private void attachOrder() {
        summaryView.getOrder().setItems(FXCollections.observableArrayList(orderViewPresenter.getOrderList()));
    }

    private void attachButtonListeners() {
        summaryView.getEnd().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                summaryView.showDialog();
            }
        });

    }



}
