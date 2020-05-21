package club.banyuan;

/**
 * 观察者发现一种动物的细节。
 */
public class Sighting {

  // 观察者的ID。
  private final int spotter;
  // 被发现的动物。
  private final String animal;
  // 发现次数。
  private final int count;
  // 看到它们的区域的ID。
  private final int area;
  // 报告日期编号
  private final int period;

  /**
   * 创建目击特定类型动物的记录。
   */
  public Sighting(int spotter, String animal, int count, int area, int period) {
    this.animal = animal;
    this.spotter = spotter;
    this.count = count;
    this.area = area;
    this.period = period;
  }

  public String getAnimal() {
    return animal;
  }

  public int getSpotter() {
    return spotter;
  }

  public int getCount() {
    return count;
  }

  public int getArea() {
    return area;
  }

  public int getPeriod() {
    return period;
  }

  public String getDetails() {
    return animal +
        ", count = " + count +
        ", area = " + area +
        ", spotter = " + spotter +
        ", period = " + period;
  }

}
