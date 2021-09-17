import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application {
    private  ElectronicStore    model;
    private ElectronicStoreView view;

    public void start(Stage primaryStage) {
        model = ElectronicStore.createStore();
        view = new ElectronicStoreView(model);

        view.getStockList().setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) { handleSelection(); }
        });

        view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) { handleAddButton(); }
        });

        view.getCartList().setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) { handleSelection(); }
        });

        view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) { handleRemoveButton(); }
        });

        view.getCompleteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) { handleCompleteButton(); }
        });

        view.getResetButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) { handleResetButton(); }
        });

        primaryStage.setTitle("Electronic Store Application - " + model.getName());
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(view, 960, 480));
        primaryStage.show();

        view.update();
    }

    public static void main(String[] args) { launch(args); }

    // Event handler for selection listviews
    private void handleSelection() {
        view.update();
    }

    // Event handler for add button
    private void handleAddButton() {
        int selectedIndex = view.getStockList().getSelectionModel().getSelectedIndex();
        model.addCart(selectedIndex);
        view.update();
    }

    // Event handler for remove button
    private void handleRemoveButton() {
        int selectedIndex = view.getCartList().getSelectionModel().getSelectedIndex();
        model.removeCart(selectedIndex);
        view.update();
    }

    // Event handler for complete button
    private void handleCompleteButton() {
        model.setNumberofSales();
        model.setRevenue(model.getCartAmount());
        for (Product p: model.getCartList()) {
            p.sellCart();
        }
        view.update();
    }

    // Event handler for reset button
    private void handleResetButton() {
        model = ElectronicStore.createStore();
        view.setModel(model);
        view.update();

    }
}
