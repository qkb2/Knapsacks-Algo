import java.util.Arrays;
import java.util.Comparator;

public class KnapsacksGreedy extends Knapsacks {
    KnapsacksGreedy(int cap) {
        super(cap);
    }
    KnapsacksGreedy() { super(0); }

    @Override
    public boolean setAnswer() {
        Item[] greedyArr = Arrays.copyOf(items, amount);
        Arrays.sort(greedyArr, Comparator.comparing(p -> -p.approx));
        maxWeight = 0;
        maxValue = 0;
        answer = new int[amount];

        for (Item item : greedyArr) {
            if (item.weight + maxWeight <= cap) {
                maxWeight += item.weight;
                maxValue += item.price;
                answer[item.idx-1] = 1;
                if (maxWeight == cap) {
                    return true;
                }
            }
        }
        return maxValue > 0;
    }
}
