/**
 * Created by jrihma on 29-Oct-16.
 */
public class Printing {
    public static void printalgus () {
        System.out.println("NBA Fantasy - head match-up'i!");

        int mina1 = 30;
        int mina2 = 20;

        int vastane = 30;

        if (mina1 - vastane > 0 || mina2 - vastane > 0) {
            System.out.println("võit!");
            if (mina2 > mina1){
                System.out.println("mina2");
            }else {
                System.out.println("mina1");
            }
        }   else if (mina1 == vastane || mina2 == vastane)  {
            System.out.println("wiik");
        }
        else {
            System.out.println("kaotus!");
        }
    }
}

