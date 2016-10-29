import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

       Printing.printalgus();
        VBox vbox = new VBox();
        Scene login = new Scene(vbox, 400, 200);
        primaryStage.setScene(login);
        primaryStage.show();

        Label pealkiri = new Label("Kes võidab mängu?");
        TextField paroolField = new TextField();

        vbox.getChildren().addAll(pealkiri, paroolField);
    }

}