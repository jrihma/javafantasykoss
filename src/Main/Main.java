import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.scene.paint.Color.GREEN;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Printing.printalgus();


       ArrayList playerList1 = ReadStats.readStats("C:\\Users\\jrihma\\Documents\\Kool\\Java\\code\\javafantasykoss\\src\\Main\\mina.csv");
       ArrayList playerList2 = ReadStats.readStats("C:\\Users\\jrihma\\Documents\\Kool\\Java\\code\\javafantasykoss\\src\\Main\\vastane.csv");
        Stats calculatedStats1 = StatsCalc.statsCalc(playerList1);
        Stats calculatedStats2 = StatsCalc.statsCalc(playerList2);
        VBox vbox = new VBox();
        Scene login = new Scene(vbox, 400, 200);
        primaryStage.setScene(login);
        primaryStage.show();

        Label pealkiri = new Label("Tulemus");
        pealkiri.setBackground(new Background(new BackgroundFill(Color.GREEN,null,null)));

        GridPane grid = new GridPane();

        int myWins = 0;
        int myLosses = 0;
        int myDraws = 0;

        grid.add(new Label("Reb"), 1, 1);
        grid.add(new Label("Ast"), 2, 1);
        Color color = Color.TRANSPARENT;
        if(calculatedStats1.reb > calculatedStats2.reb) {
            color = Color.GREEN;
            myWins = myWins +1;

        }
        else if (calculatedStats1.reb < calculatedStats2.reb){
            color = Color.RED;
            myLosses = myLosses + 1;
        }
        else {
            color = Color.YELLOW;
            myDraws = myDraws +1;
        }

        Label labelReb = new Label(Double.toString(calculatedStats1.reb));
        labelReb.setBackground(new Background(new BackgroundFill(color,null,null)));

        if(calculatedStats1.ast > calculatedStats2.ast) {
            color = Color.GREEN;
            myWins = myWins +1;

        }
        else if (calculatedStats1.ast < calculatedStats2.ast){
            color = Color.RED;
            myLosses = myLosses + 1;
        }
        else {
            color = Color.YELLOW;
            myDraws = myDraws +1;
        }


        Label labelAst = new Label(Double.toString(calculatedStats1.ast));
        labelAst.setBackground(new Background(new BackgroundFill(color,null,null)));


        grid.add(labelReb, 1, 2);
        grid.add(labelAst, 2, 2);
        grid.add(new Label(Double.toString(calculatedStats2.reb)), 1, 3);
        grid.add(new Label(Double.toString(calculatedStats2.ast)), 2, 3);
        grid.setGridLinesVisible(true);


        Label finalScore = new Label("FinalScore   " + myWins + "-" + myLosses + "-" + myDraws);
        //finalScore.setFont();
        finalScore.setTranslateX(100);
        finalScore.setTranslateY(50);



        vbox.getChildren().addAll(pealkiri, grid, finalScore);
    }

}