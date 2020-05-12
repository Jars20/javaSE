package club.banyuan;

// TODO: 实现 Measurable 接口. getMeasure() 返回国家的人口总数. 提供构造方法，让DataSetTester运行正常
public class Country implements Measurable,Measurer {
    private double numOfPeople;

    public void setNumOfPeople(double numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public Country(double numOfPeople) {
        this.setNumOfPeople(numOfPeople);
    }

    @Override
    public double getMeasure() {
        return numOfPeople;
    }

    @Override
    public double measure(Object anObject) {
        return numOfPeople;
    }
}
