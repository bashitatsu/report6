package jp.ac.uryukyu.ie.e185714;

import java.util.ArrayList;


public class Player {
    String name;
    int number;
    Card card = new Card();
    ArrayList<Integer> tehuda;
    boolean win;

    public Player(String name, int number){
        this.name = name;
        this.number = number;
        this.tehuda = my_tehuda();
        this.win = false;
    }

    /**
     * sortメソッドの2次元配列から1次元配列を取り出し、ArrayListに変換する.
     * @return ArrayList.
     */
    public ArrayList<Integer> my_tehuda(){
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
     * 手札からカードを場に出す.
     * @param input_num 入力した数字.
     */
    public void put_out(int input_num){
        int card_num = input_num;
        int tehuda_size = this.tehuda.size();
        int size_num = 0;
        if (input_num == 1 | input_num == 2){
            input_num += 13;
        }

        for (int num: tehuda){
            if (card_num == num & input_num > card.field_number){
                this.tehuda.remove(size_num);
                System.out.println("あなたが"+num+"を出しました。");
                card.field_number = input_num;
                card.pass_number = 0;
                if (this.tehuda.size() == 0){
                    this.win = true;
                }
                break;
            }
            size_num++;
        }
        if (size_num == this.tehuda.size() & tehuda_size == this.tehuda.size()){
            System.out.println("そのカードは出せません。\n自動的にパスします。");
            card.pass_number++;
        }

    }

    /**
     * パスを実行するメソッド.
     */
    public void pass(){
        System.out.println("あなたはパスしました。");
        card.pass_number++;
    }

}
