package club.banyuan;

import org.junit.Assert;
import org.junit.Test;

public class Tester {

  @Test
  public void countryTest() {
    DataSet<Country> countryData = new DataSet<>();
    countryData.add(new Country(19920));
    countryData.add(new Country(20000));
    countryData.add(new Country(45000));
    countryData.add(new Country(1100));
    Assert.assertEquals("最大人口数量", 45000, countryData.getMaximum().getMeasure(), 0);
  }

  @Test
  public void rectangleMeasurerTest() {
    Measurer<Rectangle> m = new RectangleMeasurer<>();
    DataSet<Rectangle> data = new DataSet<>(m);
    data.add(new Rectangle(15, 10));
    data.add(new Rectangle(40, 20));
    data.add(new Rectangle(20, 10));
    Assert.assertEquals("平均面积", 383, data.getAverage(), 1);
    Assert.assertEquals("最大面积矩形: ", new Rectangle(40, 20), data.getMaximum());
  }

  @Test
  public void stringMeasurerTest() {
    Measurer<String> m = new StringMeasurer<>();
    DataSet<String> data = new DataSet<>(m);
    data.add("test");
    data.add("testing");
    data.add("tester");
    data.add("retest");
    data.add("contest");
    Assert.assertEquals("平均长度:", 6, data.getAverage(), 0);
    Assert.assertEquals("最大长度的字符串", "testing", data.getMaximum());
  }
}
