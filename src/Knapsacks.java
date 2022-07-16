import java.util.ArrayList;
import java.util.Arrays;

abstract class Knapsacks {
    Item[] items;
    int amount;
    int cap;
    int maxValue;
    int maxWeight;
    int[] answer;
    ArrayList<Integer> solution;

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setItems(int[][] itemArr) {
        if (itemArr == null) {
            throw new RuntimeException("Item array cannot be null");
        }
        this.items = new Item[itemArr.length];
        this.amount = itemArr.length;
        this.answer = new int[itemArr.length];

        for (int i = 0; i < itemArr.length; i++) {
            int w = itemArr[i][0];
            int p = itemArr[i][1];
            Item item = new Item(i+1, w, p);
            this.items[i] = item;
        }
    }

    public void setItems(ArrayList<int[]> itemArr) {
        if (itemArr == null) {
            throw new RuntimeException("Item array cannot be null");
        }
        this.items = new Item[itemArr.size()];
        this.amount = itemArr.size();
        this.answer = new int[itemArr.size()];

        int[][] arr = new int[itemArr.size()][2];
        for (int i = 0; i < itemArr.size(); i++) {
            int[] ha = itemArr.get(i);
            int w = ha[0];
            int p = ha[1];
            Item item = new Item(i+1, w, p);
            this.items[i] = item;
        }
    }

    public void setItems(Item[] items) {
        if (items == null) {
            throw new RuntimeException("Item array cannot be null");
        }
        this.items = items;
        this.amount = items.length;
        this.answer = new int[items.length];
    }

    Knapsacks(int cap) {
        this.cap = Math.abs(cap);
    }

    public boolean setAnswer() {
        answer = new int[amount];
        return false;
    }

    public void setSolution() {
        solution = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            if (answer[i] == 1) {
                solution.add(i+1);
            }
        }
    }
}
