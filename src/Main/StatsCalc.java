import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by jrihma on 20-Dec-16.
 */
public class StatsCalc {

    public static Stats statsCalc (ArrayList<Stats> playerList) {

        Stats total = new Stats();




        for (Stats stats: playerList) {

            total.ast = total.ast + stats.ast*stats.gamesPlayed;
            total.threePM = total.threePM + stats.threePM*stats.gamesPlayed;
            total.reb = total.reb + stats.reb*stats.gamesPlayed;
            total.stl = total.stl + stats.stl*stats.gamesPlayed;
            total.blk = total.blk + stats.blk*stats.gamesPlayed;
            total.pts = total.pts + stats.pts*stats.gamesPlayed;
            total.fieldGoalAttempts = total.fieldGoalAttempts + stats.gamesPlayed*stats.fieldGoalAttempts;
            total.fieldGoalMade = total.fieldGoalMade + stats.gamesPlayed*stats.fieldGoalAttempts*stats.fieldGoalPercentage;
            total.freeThrowAttempts = total.freeThrowAttempts + stats.gamesPlayed*stats.freeThrowAttempts;
            total.freeThrowMade = total.freeThrowMade + stats.gamesPlayed*stats.freeThrowAttempts*stats.freeThrowPercentage;


            //total fieldGoalPercentage is total.fieldGoalMade/total.fieldGoalAttempts
            //total freeThrowPercentage is total.freeThrowMade/total.freeThrowAttemtps
            //System.out.println(stats);
        }

        total.threePM = Math.round(total.threePM*100.0)/100.0;
        total.reb = Math.round(total.reb*100.0)/100.0;
        total.ast = Math.round(total.ast*100.0)/100.0;
        total.stl = Math.round(total.stl*100.0)/100.0;
        total.blk = Math.round(total.blk*100.0)/100.0;
        total.pts = Math.round(total.pts*100.0)/100.0;

        total.fieldGoalPercentage = total.fieldGoalMade/total.fieldGoalAttempts;
        total.freeThrowPercentage = total.freeThrowMade/total.freeThrowAttempts;

        total.fieldGoalPercentage = Math.round(total.fieldGoalPercentage*1000.0)/1000.0;
        total.freeThrowPercentage = Math.round(total.freeThrowPercentage*1000.0)/1000.0;



        return total;


    }
}
