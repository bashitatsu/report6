package jp.ac.uryukyu.ie.e185714;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    /**
     * 配られた枚数が4等分した値になっているかを確認。
     */
    @Test
    void my_tehuda() {
        Player player = new Player("プレイヤー", 0);
        assertEquals(13,player.tehuda.size());
    }
}