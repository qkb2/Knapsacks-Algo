import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KnapsacksBruteForceTest {

    @org.junit.jupiter.api.Test
    void decToBin() {
        int[] exp = {0,0,0,1,1,0,0,1};
        var got = KnapsacksBruteForce.decToBin(25,8);
        assertArrayEquals(exp, got);
    }

    @org.junit.jupiter.api.Test
    void setAnswer() {
        int[][] itemArr = {{2,4},{1,3},{4,6},{4,8}};
        var knapsack = new KnapsacksBruteForce(8);
        knapsack.setItems(itemArr);
        boolean p = knapsack.setAnswer();
        knapsack.setSolution();
        int[] ansExp = {1,1,0,1};
        var ansGot = knapsack.answer;
        ArrayList<Integer> solExp = new ArrayList<>();
        solExp.add(1);
        solExp.add(2);
        solExp.add(4);
        var solGot = knapsack.solution;
        assertTrue(p);
        assertArrayEquals(ansExp, ansGot);
        assertIterableEquals(solExp, solGot);
    }
}