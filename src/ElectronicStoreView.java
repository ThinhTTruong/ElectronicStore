import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.ListView;

public class ElectronicStoreView extends Pane {
    private ElectronicStore     model;
    private Button              addButton, removeButton, completeButton, resetButton;
    private ListView<String>    popularList, stockList, cartList;
    private TextField           salesField, revenueField, averageField;
    private Label               label3;
    public ElectronicStoreView(ElectronicStore initModel) {
        model = initModel;

        // Create the labels
        Label label1 = new Label("Store Summary:");
        label1.relocate(80, 20);
        Label label2 = new Label("Store Stock:");
        label2.relocate(350, 20);
        label3 = new Label("Current Cart:");
        label3.relocate(700, 20);
        Label label4 = new Label("# Sales:");
        label4.relocate(40, 50);
        label4.setPrefSize(60.0D, 30.0D);
        Label label5 = new Label("Revenue:");
        label5.relocate(40, 85);
        label5.setPrefSize(60.0D, 30.0D);
        Label label6 = new Label("$ / Sale:");
        label6.relocate(40, 120);
        label6.setPrefSize(60.0D, 30.0D);
        Label label7 = new Label("Most Popular Items:");
        label7.relocate(60, 160);
        label7.setPrefSize(200.0D, 40.0D);

        // Create the TextFields
        salesField = new TextField();
        salesField.relocate(100, 50);
        salesField.setPrefSize(120,30);
        salesField.setEditable(false);
        revenueField = new TextField();
        revenueField.relocate(100, 85);
        revenueField.setPrefSize(120,30);
        revenueField.setEditable(false);
        averageField = new TextField();
        averageField.relocate(100, 120);
        averageField.setPrefSize(120,30);
        averageField.setEditable(false);

        // Create the lists
        popularList = new ListView<String>();
        popularList.relocate(20, 200);
        popularList.setPrefSize(200,200);

        stockList = new ListView<String>();
        stockList.relocate(230, 50);
        stockList.setPrefSize(350,350);

        cartList = new ListView<String>();
        cartList.relocate(590, 50);
        cartList.setPrefSize(350,350);

        // Create the buttons
        resetButton = new Button("Reset Store");
        resetButton.setStyle("-fx-font: 12 arial;");
        resetButton.relocate(35, 410);
        resetButton.setPrefSize(170,50);

        addButton = new Button("Add to Cart");
        addButton.setStyle("-fx-font: 12 arial;");
        addButton.relocate(320, 410);
        addButton.setPrefSize(170,50);

        removeButton = new Button("Remove from Cart");
        removeButton.setStyle("-fx-font: 12 arial;");
        removeButton.relocate(590, 410);
        removeButton.setPrefSize(170,50);

        completeButton = new Button("Complete Sale");
        completeButton.setStyle("-fx-font: 12 arial;");
        completeButton.relocate(770, 410);
        completeButton.setPrefSize(170,50);

        // Add all the components to the Pane
        getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, popularList, stockList,
                cartList, resetButton, addButton, removeButton, completeButton, salesField, revenueField, averageField);
    }

    // Get methods
    public Button getAddButton() { return addButton; }
    public Button getRemoveButton() { return removeButton; }
    public Button getCompleteButton() { return completeButton; }
    public Button getResetButton() { return resetButton; }
    public ListView<String> getStockList() { return stockList; }
    public ListView<String> getCartList() { return cartList; }

    // Set model to a new electronic store model
    public void setModel(ElectronicStore newModel) {
        model = newModel;
    }

    // Update the view based on model
    public void update() {
        String[] stocks = new String[model.getAvailableList().length];
        String[] populars = new String[3];
        String[] carts = new String[model.getCartList().length];

        for (int i=0; i < model.getAvailableList().length; i++) {
            stocks[i] = model.getAvailableList()[i].getInfo();
        }

        for (int i=0; i < model.getCartList().length; i++) {
            carts[i] = model.getCartList()[i].getCartQuantity() + " x " + model.getCartList()[i].getInfo();
        }
        for (int i=0; i < 3; i++) {
            populars[i] = model.getPopularList()[i].getInfo();
        }
        stockList.setItems(FXCollections.observableArrayList(stocks));
        popularList.setItems(FXCollections.observableArrayList(populars));
        cartList.setItems(FXCollections.observableArrayList(carts));

        // enable/disable buttons
        addButton.setDisable(stockList.getSelectionModel().getSelectedIndex()<0);

        removeButton.setDisable(cartList.getSelectionModel().getSelectedIndex()<0);

        completeButton.setDisable(carts.length <= 0);

        label3.setText(String.format("Current Cart ($%,1.2f):", model.getCartAmount()));
        salesField.setText("" + model.getNumberofSales());
        revenueField.setText(""+ model.getRevenue());
        if (model.getRevenue() !=0) {
            averageField.setText("" + String.format("%1.2f",model.getRevenue() / model.getNumberofSales()));
        } else {
            averageField.setText("N/A");
        }
    }
}
