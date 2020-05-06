package club.banyuan;

public class OrderCake extends Cake{
    public double weightInKG;

    public OrderCake(int n, double r, double weightInKG) {
        super(n, r);
        this.weightInKG = weightInKG;
    }

    @Override
    public double calcPrice() {
        return price*weightInKG;
    }
}
