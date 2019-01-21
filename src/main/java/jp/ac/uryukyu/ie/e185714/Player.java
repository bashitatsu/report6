package jp.ac.uryukyu.ie.e185714;

import java.util.ArrayList;

public class Player {
    String name;
    int number;
    Card card = new Card();
    ArrayList<Integer> tehuda;
    int[] choice_num;

    public Player(String name, int number){
        this.name = name;
        this.number = number;
        this.tehuda = my_tehuda();
    }

    public ArrayList<Integer> my_tehuda(){
        int[][] tehuda = card.seiri();
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

    public void dasu(){
        for (int card_num: choice_num){
            for (int num: tehuda){
                if (card_num == num){
                    this.tehuda.remove(num);
                    System.out.println(this.name+"が"+num+"を出しました。");
                }
            }
        }
    }



}
