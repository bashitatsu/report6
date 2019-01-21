package jp.ac.uryukyu.ie.e185714;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Player pr = new Player("プレイヤー",0);
        Enemy com1 = new Enemy("com1",1);
        Enemy com2 = new Enemy("com2",2);
        Enemy com3 = new Enemy("com3",3);
        Card card = new Card();

        Scanner in = new Scanner(System.in);

        while (pr.win==false | com1.win==false | com2.win==false | com3.win==false){
            if (card.pass_number == 3){
                System.out.println("場が流れたので親は"+pr.name+"です。");
                card.field_number = 0;
                card.pass_number = 0;
            }
            System.out.println("あなたのターンです。カードを出してください。");
            System.out.println("あなたの手札\n"+pr.tehuda);
            while (true){
                String s = in.nextLine();
                try {
                    int input = Integer.parseInt(s);
                    pr.put_out(input);
                    break;
                }catch (NumberFormatException e){
                    if (String.valueOf(s).equals("p")){
                        pr.pass();
                        break;
                    }
                    System.out.println("エラーが発生しました。\nもう一度選んでください。");
                }
            }
            com1.put_out();
            com2.put_out();
            com3.put_out();
        }
    }
}
