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
            System.out.println(stats);
        }

        total.fieldGoalPercentage = total.fieldGoalMade/total.fieldGoalAttempts;
        total.freeThrowPercentage = total.freeThrowMade/total.freeThrowAttempts;

        return total;


    }
}
