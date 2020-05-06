package club.banyuan;

public class ReadyMadeCake extends Cake{
    public int qunantity;

    public ReadyMadeCake(int n, double r, int s) {
        super(n, r);
        this.qunantity = s;
    }

    @Override
    public double calcPrice() {
        return price*qunantity;
    }
}
