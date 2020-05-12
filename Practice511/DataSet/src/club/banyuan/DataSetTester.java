package club.banyuan;

public class DataSetTester {

  public static void main(String[] args) {
    // TODO: 实现相关代码。
    DataSet countryData = new DataSet();
    countryData.add(new Country(19920));
    countryData.add(new Country(20000));
    countryData.add(new Country(45000));
    countryData.add(new Country(1100));
    Measurable max = (Measurable) countryData.getMaximum();
    System.out.println("最高人口数为: " + max.getMeasure());
    Country country = (Country)max;
    System.out.println("最高人口数为: " + country.getMeasure());
    System.out.println("输出应该为: 45000");

  }
}
