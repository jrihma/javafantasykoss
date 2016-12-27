import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jrihma on 20-Dec-16.
 */
public class ReadStats {
    public static ArrayList readStats (String failiAsukoht) {
        System.out.println("NBA Fantasy - head match-up'i!");

        File f = new File(failiAsukoht);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {

            if (br != null) {
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList playerList = new ArrayList();
        while (line != null) {
            System.out.println(line);





            try {
                line = br.readLine();
                if (line != null){
                    Stats player1 = lineToArray(line);

                    playerList.add(player1);
                }



            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return playerList;
    }

    private static Stats lineToArray(String line){
        //PG,"Eric Bledsoe, Pho�PG",,,"3:�@Min,�Hou,�Phi",,14,33.1,7.7/17.8,0.434,5.3/6.1,0.86,1.9,5.1,5.6,2.1,0.8,22.6,,10.76,98.8,0

        int kolmKoma = line.indexOf(",,,");
        String gamesPlayed = line.substring(kolmKoma + 4, kolmKoma +5);
        line = line.substring(kolmKoma + 5);
        int kaksKoma = line.indexOf(",,");
        line = line.substring(kaksKoma + 2);
        String[] split = line.split(",");


        Stats stats = new Stats();

        int gamesPlayedInt = Integer.parseInt(gamesPlayed);
        stats.gamesPlayed = gamesPlayedInt;
        stats.ast = Double.parseDouble(split[8]);
        stats.threePM = Double.parseDouble(split[6]);
        stats.reb = Double.parseDouble(split[7]);
        stats.stl = Double.parseDouble(split[9]);
        stats.blk = Double.parseDouble(split[10]);
        stats.pts = Double.parseDouble(split[11]);
        stats.fieldGoalPercentage = Double.parseDouble(split[3]);
        stats.freeThrowPercentage = Double.parseDouble(split[5]);


        int kaldkriips1 = split[2].indexOf("/");
        String fieldGoal = split[2].substring(kaldkriips1 + 1);
        stats.fieldGoalAttempts = Double.parseDouble(fieldGoal);

        int kaldkriips2 = split[4].indexOf("/");
        String freeThrow = split[4].substring(kaldkriips2 +1);
        stats.freeThrowAttempts = Double.parseDouble(freeThrow);






        return stats;
    }


}
