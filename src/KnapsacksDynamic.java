public class KnapsacksDynamic extends Knapsacks {
    int[][] dm;

    KnapsacksDynamic(int cap) {
        super(cap);
    }
    KnapsacksDynamic() {
        super(0);
    }

    private void answerHelper(int i, int j) {
        if (i == 0) {
            return;
        }
        if (dm[i][j] > dm[i-1][j]) {
            answer[i-1] = 1;
            maxWeight += items[i-1].weight;
            answerHelper(i-1, j-items[i-1].weight);

        } else {
            answerHelper(i-1, j);
        }
    }

    @Override
    public boolean setAnswer() {
        maxWeight = 0;
        dm = new int[amount+1][cap+1];

        for (int i = 1; i < amount+1; i++) {
            for (int j = 1; j < cap+1; j++) {

                if (items[i-1].weight > j) {
                    dm[i][j] = dm[i-1][j];
                } else {
                    dm[i][j] = Math.max(
                            dm[i-1][j],
                            dm[i-1][j-items[i-1].weight] + items[i-1].price);
                }
            }
        }
        maxValue = dm[amount][cap];
        answerHelper(amount, cap);
        return maxValue > 0;
    }
}
