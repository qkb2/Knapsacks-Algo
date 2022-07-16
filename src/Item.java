public class Item {
    int idx;
    int weight;
    int price;
    double approx;

    Item(int idx, int weight, int price) {
        this.idx = idx;
        this.weight = weight;
        this.price = price;
        this.approx = (double) price/weight;
    }

    public double getApprox() {
        return approx;
    }
}
