import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jrihma on 20-Dec-16.
 * <p>
 * Siin klassis loen sisse andmed failidest ning leian ridadest muutujatele õiged väärtused
 * Loon meetodi readStats, mis sisaldab objekti ArrayList ning annan String tüüpi sisendi. Sisend on csv faili asukoht, mis on kirjas Main klassis
 */
public class ReadStats {

    public static ArrayList readStats(String fileLocation) {
        System.out.println("NBA Fantasy - have a good match-up, boss!");

                // Kasutan i200 materjalidest võetud "Faili lugemine" koodi
        File f = new File(fileLocation); // Näitan faili asukoha
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f)); //Loeb faili
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //Kui faili ei leia, siis prindib errori.
        }
        String line = null; // Loon sõne, millele algselt ei omasta väärtust
        try {

            if (br != null) {
                line = br.readLine(); // Kui failis on mingi tekst reaga, siis loe see rida
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList playerList = new ArrayList(); // Loon uue Arraylist'i playerList

        while (line != null) {
            System.out.println(line); // nii kaua kuni on ridu, mida lugeda, siis prindime read välja

            try {
                line = br.readLine();
                if (line != null) {

                    Stats player = lineToArray(line);  // Kutsun välja meetodi, mis muudab tekstirea objektiks, mis sisaldab ühe mängija statistikat
                    playerList.add(player); // Lisan iga mängija statistika Arraylist'i while tsüklis
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            br.close(); // Peale ridade lõppemist, lõpetada lugemine
        } catch (IOException e) {
            e.printStackTrace();
        }


        return playerList; // tagastan Arraylist'i
    }


    private static Stats lineToArray(String line) { // Loon uue meetodi, kus töötlen rida, et saada kätte vajalikud statistilised näitajad

        //PG,"Eric Bledsoe, Pho�PG",,,"3:�@Min,�Hou,�Phi",,14,33.1,7.7/17.8,0.434,5.3/6.1,0.86,1.9,5.1,5.6,2.1,0.8,22.6,,10.76,98.8,0

        int kolmKoma = line.indexOf(",,,");

        // Otsin reast koha, kus on kolm koma järjest (see juhtub ainult ühes kohas). Miks on oluline võtta kole koma asukoht,
        // on seetõttu, et alati mängude arv on peale kolme koma ning jutumärki. Mängijate nimed on erineva pikkusega ning samuti on mõnel mängijal lisa positsioonid ning seetõttu otsene asukoht ei töötaks.

        String gamesPlayed = line.substring(kolmKoma + 4, kolmKoma + 5); // Mängude arvu number on 4 kohta pärast komade algust. Samuti annan lõpu asukoha, et programm ei haaraks seda, mis tuleb peale mängude arvu.
        line = line.substring(kolmKoma + 5); // Defineerin rea uuesti sedasi, et rida hakkaks peale kolme koma. See on tähtis, kuna järgmiseks on oluline kahe koma asukoht ning kolma koma sisaldab samtui kahe koma.
        int kaksKoma = line.indexOf(",,"); // Defineerin kahe koma asukoha
        line = line.substring(kaksKoma + 2); // Alustan reaga nüüd peale kahte koma, kus jõuan järgmiste oluliste numbriteni, mis on kõik ühtemoodi komadega eraldatud.
        String[] split = line.split(","); // Loon String tüüpi massiivi, kus rida on jaotatud eraldi sõnedeks. Kasutan split käsklust.


        Stats stats = new Stats(); // Loon vastavad statistilised väärtused ja teen sõnedest vastavalt int ja double väärtused

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


        // Kuna fieldCoalMade ja fieldCoalAttempted ning freeThrowMade ja freeThrowAttempted on ühe sõne all kujul 8.5/19.9, siis tuleb eelnevalt anda nende õige asukoht. Meil on viskeprotsent teada ja seetõttu on meile oluline Attemps mitte Made.
        int kaldkriips1 = split[2].indexOf("/"); // Defineerin kaldkriipsu asukoha, mis asub positisioonil split[2]
        String fieldGoal = split[2].substring(kaldkriips1 + 1); // Leian asukoha, mis on split listis teisel kohal, ning arvu, mis on tuleb peale kaldkriipsu
        stats.fieldGoalAttempts = Double.parseDouble(fieldGoal); // Defineerin fieldCoalAttempts

        int kaldkriips2 = split[4].indexOf("/"); // Sarnaselt freeThrowAttempts
        String freeThrow = split[4].substring(kaldkriips2 + 1);
        stats.freeThrowAttempts = Double.parseDouble(freeThrow);

        return stats; // tagastan muutujate väärtused
    }


}
