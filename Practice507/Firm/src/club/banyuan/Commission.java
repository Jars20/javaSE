package club.banyuan;

public class Commission extends Hourly{
    private double totalSales = 0.0;
    private final double commissionRate;
    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate,double commissionRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
    }
    public void addSales(double totalSales){
        this.totalSales += totalSales;
    }

    @Override
    public double pay() {
        return super.pay() + totalSales*commissionRate;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "\n销售总额: " + totalSales;
        return result;
    }
}
