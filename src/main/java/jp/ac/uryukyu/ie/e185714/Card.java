package jp.ac.uryukyu.ie.e185714;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Card {
    private final int CARD_NUM = 13,
            ALL_CARD_NUM = 52,
            MEMBER_NUM = 4;

    ArrayList<Integer> yamahuda;
    static int field_number = 0;
    static int pass_number = 0;

    public Card(){
        this.yamahuda = allcard();

    }

    public ArrayList allcard(){
        ArrayList<Integer> yamahuda = new ArrayList<Integer>();
        for (int i = 0; i < MEMBER_NUM; i++) {
            for (int n = 0; n < CARD_NUM; n++) {
                yamahuda.add(n + 1);
            }
        }
        return yamahuda;
    }


    public int[][] haihu() {
        int tehuda[][] = new int[MEMBER_NUM][CARD_NUM];
        int k = 0;
        for (int i = 0, n = 0; i < ALL_CARD_NUM; i++, n++) {
            if (n == 4) {
                n = 0;
                k++;
            }
            Random rnd = new Random();
            int rnd1 = rnd.nextInt(this.yamahuda.size());
            tehuda[n][k] = this.yamahuda.get(rnd1);
            this.yamahuda.remove(rnd1);
        }
        return tehuda;
    }

    public int[][] seiri(){
        int[][] tehuda = haihu();
        int[][] my_tehuda = new int[MEMBER_NUM][CARD_NUM];
        int n = 0;
        for (int[] tehuda2: tehuda){
            Arrays.sort(tehuda2);
            my_tehuda[n] = tehuda2;
            n++;
        }
        return my_tehuda;
    }

}
