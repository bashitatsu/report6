package jp.ac.uryukyu.ie.e185714;

import java.util.ArrayList;
import java.util.Random;

public class Enemy{
    String name;
    int number;
    Card card = new Card();
    ArrayList<Integer> tehuda;
    private final int CARD_NUM = 13;
    boolean win;

    public Enemy(String name,int number){
        this.name = name;
        this.number = number;
        this.tehuda = enemy_tehuda();
        this.win = false;
    }

    /**
     * sortメソッドの2次元配列から1次元配列を取り出し、ArrayListに変換する.
     * @return ArrayList.
     */
    public ArrayList<Integer> enemy_tehuda(){
        int[][] tehuda = card.sort();
        int x_number = 0;
        int[] my_tehuda = new int[1];
        for (int[] a_tehuda: tehuda){
            if (this.number == x_number){
                my_tehuda = a_tehuda;
                break;
            }
            x_number++;
        }
        this.tehuda = new ArrayList<Integer>();
        for (int num: my_tehuda){
            this.tehuda.add(num);
        }
        return this.tehuda;
    }

    /**
     * 手札からカードを場に出す。
     */
    public void put_out(){

        if (card.pass_number == 3){
            System.out.println("場が流れたので親は"+this.name+"です。");
            card.field_number = 0;
            card.pass_number = 0;
        }

        int tehuda_size = this.tehuda.size();
        int size_num = 0;
        Random rnd = new Random();

        int enemy_card_num = 0;
        enemy_card_num = rnd.nextInt(CARD_NUM+1);
        int original_num = enemy_card_num;

        if (enemy_card_num == 1 | enemy_card_num == 2){
            enemy_card_num += 13;
        }

        for (int num: this.tehuda){
            if (num == original_num & enemy_card_num > card.field_number){
                this.tehuda.remove(size_num);
                System.out.println(this.name+"が"+num+"を出しました。");
                card.field_number = enemy_card_num;
                card.pass_number = 0;
                if (this.tehuda.size() == 0){
                    this.win = true;
                }
                break;
            }
            size_num++;

        }
        if (size_num == this.tehuda.size() & tehuda_size == this.tehuda.size()){
            System.out.println(this.name+"はパスしました。");
            card.pass_number++;
        }
    }
}
