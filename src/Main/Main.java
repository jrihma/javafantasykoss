import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static javafx.scene.paint.Color.GREEN;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {



       ArrayList playerList1 = ReadStats.readStats("C:\\Users\\jrihma\\Documents\\Kool\\Java\\code\\javafantasykoss\\src\\Main\\mina.csv");
       ArrayList playerList2 = ReadStats.readStats("C:\\Users\\jrihma\\Documents\\Kool\\Java\\code\\javafantasykoss\\src\\Main\\vastane.csv");
        Stats calculatedStats1 = StatsCalc.statsCalc(playerList1);
        Stats calculatedStats2 = StatsCalc.statsCalc(playerList2);
        VBox vbox = new VBox();
        Scene login = new Scene(vbox, 800, 300);
        primaryStage.setScene(login);
        primaryStage.show();

        Label pealkiri = new Label("Total Stats & Game Result");
        //pealkiri.setBackground(new Background(new BackgroundFill(Color.GREEN,null,null)));
        pealkiri.setFont(Font.font("Verdana", 20));

        GridPane grid = new GridPane();
        grid.setTranslateX(100);
        grid.setTranslateY(50);

        int myWins = 0;
        int myLosses = 0;
        int myDraws = 0;

        grid.add(new Label("FieldGoal %"), 2, 1);
        grid.add(new Label("FreeThrow %"), 3, 1);
        grid.add(new Label(" 3PM"), 4, 1);
        grid.add(new Label(" Reb"), 5, 1);
        grid.add(new Label(" Ast"), 6, 1);
        grid.add(new Label(" Stl"), 7, 1);
        grid.add(new Label(" Blk"), 8, 1);
        grid.add(new Label(" Pts"), 9, 1);
        grid.add(new Label(" Me"), 1, 2);
        grid.add(new Label(" Opponent"), 1, 3);

        Color color = Color.TRANSPARENT;

        if(calculatedStats1.fieldGoalPercentage > calculatedStats2.fieldGoalPercentage) {
            color = Color.LIGHTGREEN;
            myWins = myWins +1;

        }
        else if (calculatedStats1.fieldGoalPercentage < calculatedStats2.fieldGoalPercentage){
            color = Color.LIGHTSALMON;
            myLosses = myLosses + 1;
        }
        else {
            color = Color.YELLOW;
            myDraws = myDraws +1;
        }

        Label labelFieldGoal = new Label(Double.toString(calculatedStats1.fieldGoalPercentage));
        Label labelFieldGoalOpponent = new Label(Double.toString(calculatedStats2.fieldGoalPercentage));
        labelFieldGoal.setBackground(new Background(new BackgroundFill(color,null,null)));
        labelFieldGoal.setFont(Font.font("Verdana", 24));
        labelFieldGoalOpponent.setFont(Font.font("Verdana", 24));

        if(calculatedStats1.freeThrowPercentage > calculatedStats2.freeThrowPercentage) {
            color = Color.LIGHTGREEN;
            myWins = myWins +1;

        }
        else if (calculatedStats1.freeThrowPercentage < calculatedStats2.freeThrowPercentage){
            color = Color.LIGHTSALMON;
            myLosses = myLosses + 1;
        }
        else {
            color = Color.YELLOW;
            myDraws = myDraws +1;
        }

        Label labelFreeThrow = new Label(Double.toString(calculatedStats1.freeThrowPercentage));
        Label labelFreeThrowOpponent = new Label(Double.toString(calculatedStats2.freeThrowPercentage));
        labelFreeThrow.setBackground(new Background(new BackgroundFill(color,null,null)));
        labelFreeThrow.setFont(Font.font("Verdana", 24));
        labelFreeThrowOpponent.setFont(Font.font("Verdana", 24));



        if(calculatedStats1.threePM > calculatedStats2.threePM) {
            color = Color.LIGHTGREEN;
            myWins = myWins +1;

        }
        else if (calculatedStats1.threePM < calculatedStats2.threePM){
            color = Color.LIGHTSALMON;
            myLosses = myLosses + 1;
        }
        else {
            color = Color.YELLOW;
            myDraws = myDraws +1;
        }


        Label labelThreePointMade = new Label(Double.toString(calculatedStats1.threePM));
        Label labelThreePointMadeOpponent = new Label(Double.toString(calculatedStats2.threePM));
        labelThreePointMade.setBackground(new Background(new BackgroundFill(color,null,null)));
        labelThreePointMade.setFont(Font.font("Verdana", 24));
        labelThreePointMadeOpponent.setFont(Font.font("Verdana", 24));

        if(calculatedStats1.reb > calculatedStats2.reb) {
            color = Color.LIGHTGREEN;
            myWins = myWins +1;

        }
        else if (calculatedStats1.reb < calculatedStats2.reb){
            color = Color.LIGHTSALMON;
            myLosses = myLosses + 1;
        }
        else {
            color = Color.YELLOW;
            myDraws = myDraws +1;
        }

        Label labelReb = new Label(Double.toString(calculatedStats1.reb));
        Label labelRebOpponent = new Label(Double.toString(calculatedStats2.reb));
        labelReb.setBackground(new Background(new BackgroundFill(color,null,null)));
        labelReb.setFont(Font.font("Verdana", 24));
        labelRebOpponent.setFont(Font.font("Verdana", 24));

        if(calculatedStats1.ast > calculatedStats2.ast) {
            color = Color.LIGHTGREEN;
            myWins = myWins +1;

        }
        else if (calculatedStats1.ast < calculatedStats2.ast){
            color = Color.LIGHTSALMON;
            myLosses = myLosses + 1;
        }
        else {
            color = Color.YELLOW;
            myDraws = myDraws +1;
        }

        Label labelAst = new Label(Double.toString(calculatedStats1.ast));
        Label labelAstOpponent = new Label(Double.toString(calculatedStats2.ast));
        labelAst.setBackground(new Background(new BackgroundFill(color,null,null)));
        labelAst.setFont(Font.font("Verdana", 24));
        labelAstOpponent.setFont(Font.font("Verdana", 24));


        if(calculatedStats1.stl > calculatedStats2.stl) {
            color = Color.LIGHTGREEN;
            myWins = myWins +1;

        }
        else if (calculatedStats1.stl < calculatedStats2.stl){
            color = Color.LIGHTSALMON;
            myLosses = myLosses + 1;
        }
        else {
            color = Color.YELLOW;
            myDraws = myDraws +1;
        }

        Label labelStl = new Label(Double.toString(calculatedStats1.stl));
        Label labelStlOpponent = new Label(Double.toString(calculatedStats2.stl));
        labelStl.setBackground(new Background(new BackgroundFill(color,null,null)));
        labelStl.setFont(Font.font("Verdana", 24));
        labelStlOpponent.setFont(Font.font("Verdana", 24));


        if(calculatedStats1.blk > calculatedStats2.blk) {
            color = Color.LIGHTGREEN;
            myWins = myWins +1;

        }
        else if (calculatedStats1.blk < calculatedStats2.blk){
            color = Color.LIGHTSALMON;
            myLosses = myLosses + 1;
        }
        else {
            color = Color.YELLOW;
            myDraws = myDraws +1;
        }


        Label labelBlk = new Label(Double.toString(calculatedStats1.blk));
        Label labelBlkOpponent = new Label(Double.toString(calculatedStats2.blk));
        labelBlk.setBackground(new Background(new BackgroundFill(color,null,null)));
        labelBlk.setFont(Font.font("Verdana", 24));
        labelBlkOpponent.setFont(Font.font("Verdana", 24));


        if(calculatedStats1.pts > calculatedStats2.pts) {
            color = Color.LIGHTGREEN;
            myWins = myWins +1;

        }
        else if (calculatedStats1.pts < calculatedStats2.pts){
            color = Color.LIGHTSALMON;
            myLosses = myLosses + 1;
        }
        else {
            color = Color.YELLOW;
            myDraws = myDraws +1;
        }

        Label labelPts = new Label(Double.toString(calculatedStats1.pts));
        Label labelPtsOpponent = new Label(Double.toString(calculatedStats2.pts));
        labelPts.setBackground(new Background(new BackgroundFill(color,null,null)));
        labelPts.setFont(Font.font("Verdana", 24));
        labelPtsOpponent.setFont(Font.font("Verdana", 24));


        grid.add(labelFieldGoal, 2, 2);
        grid.add(labelFieldGoalOpponent, 2, 3);

        grid.add(labelFreeThrow, 3, 2);
        grid.add(labelFreeThrowOpponent, 3, 3);

        grid.add(labelThreePointMade, 4, 2);
        grid.add(labelThreePointMadeOpponent, 4, 3);

        grid.add(labelReb, 5, 2);
        grid.add(labelRebOpponent, 5, 3);

        grid.add(labelAst, 6, 2);
        grid.add(labelAstOpponent, 6, 3);

        grid.add(labelStl, 7, 2);
        grid.add(labelStlOpponent, 7, 3);

        grid.add(labelBlk, 8, 2);
        grid.add(labelBlkOpponent, 8, 3);

        grid.add(labelPts, 9, 2);
        grid.add(labelPtsOpponent, 9, 3);



        grid.setGridLinesVisible(true);


        Label finalScore = new Label("FinalScore   " + myWins + "-" + myLosses + "-" + myDraws);
        //finalScore.setFont();
        finalScore.setTranslateX(300);
        finalScore.setTranslateY(70);
        finalScore.setFont(Font.font("Verdana", 20));

        Label gameResult = null;

        if (myWins > myLosses) {
            gameResult = new Label("Boss, you have won the game");
            gameResult.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN,null,null)));
        }
        else if (myWins < myLosses) {
            gameResult = new Label("Sad to see you loose, Boss");
            gameResult.setBackground(new Background(new BackgroundFill(Color.LIGHTSALMON,null,null)));
        }
        else {
            gameResult = new Label("Draw! That's boring, Boss");
            gameResult.setBackground(new Background(new BackgroundFill(Color.YELLOW,null,null)));
        }

        gameResult.setTranslateX(200);
        gameResult.setTranslateY(75);
        gameResult.setFont(Font.font("Verdana", 30));

        vbox.getChildren().addAll(pealkiri, grid, finalScore, gameResult);

    }

}