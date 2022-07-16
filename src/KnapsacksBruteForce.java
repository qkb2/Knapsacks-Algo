public class KnapsacksBruteForce extends Knapsacks {
    KnapsacksBruteForce(int cap) { super(cap); }
    KnapsacksBruteForce() { super(0); }

    public static int[] decToBin(int num, int len) {
        int[] bits = new int[len];
        if (num == 0 || len == 0) {
            return bits;
        }

        int i = len-1;
        while (i >= 0) {
            bits[i--] = num % 2;
            num >>= 1;
        }
        return bits;
    }

    @Override
    public boolean setAnswer() {
        maxValue = 0;
        maxWeight = 0;
        answer = new int[amount];

        int range = 1<<amount;
        for (int i = 1; i < range; i++) {
            int[] binHack = decToBin(i, amount);
            int w = 0;
            int f = 0;

            for (int j = 0; j < amount; j++) {
                if (binHack[j] == 1) {
                    w += items[j].weight;
                    f += items[j].price;
                }
            }

            if (w <= cap && f > maxValue) {
                maxValue = f;
                answer = binHack.clone();
                maxWeight = w;
            }
        }
        return maxValue > 0;
    }
}
