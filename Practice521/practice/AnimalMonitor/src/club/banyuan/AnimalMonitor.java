package club.banyuan;

import java.util.List;
import java.util.List;

public interface AnimalMonitor {

  /**
   * 打印所有目击动物的详细信息。
   */
  void printList();

  /**
   * 打印给定动物的所有目击细节。
   *
   * @param animal 动物的类型。
   */
  void printSightingsOf(String animal);

  /**
   * 打印给定观察者的所有目击动物。
   *
   * @param spotter 观察者的ID。
   */
  void printSightingsBy(int spotter);

  /**
   * 打印一份被视为濒临灭绝的动物的清单。
   *
   * @param animalNames     动物名称列表。
   * @param dangerThreshold 小于或等于此级别的动物总数被认为濒临灭绝的
   */
  void printEndangered(List<String> animalNames,
      int dangerThreshold);

  /**
   * 打印在特定期间periodID内记录的所有目击事件的详细信息，并将其作为参数传递给该方法
   *
   * @param period 日期ID
   * @return 指定日期的清单
   */

  List<Sighting> printSightingsInPeriod(int period);


  /**
   * 打印并返回指定日期区间内的清单
   *
   * @param fromPeriod 日期开始
   * @param toPeriod   日期结束
   * @param animal     动物类型
   */
  List<Sighting> printSightingsOfInPeriod(int fromPeriod, int toPeriod, String animal);


  /**
   * 打印特定动物类型的总的目击数量
   *
   * @param animal 动物类型
   */
  List<Sighting> printCounts(String animal);

  /**
   * 返回给定动物目击次数。
   *
   * @param animal 动物的类型。
   * @return 给定动物的目击次数总数。
   */
  int getCount(String animal);

  /**
   * 从发现清单中删除计数为零的记录。
   */
  void removeZeroCounts();

  /**
   * 返回特定区域内给定类型的动物的所有动物清单。
   *
   * @param animal 动物的类型。
   * @param area   区域的ID。
   * @return 目击清单。
   */
  List<Sighting> getSightingsInArea(String animal, int area);

  /**
   * 返回给定动物的所有目击清单。
   *
   * @param animal 动物的类型。
   * @return 给定动物的所有目击物清单。
   */
  List<Sighting> getSightingsOf(String animal);


  /**
   * @param spotter
   * @param period
   * @return 包含该观察者在特定日期看到的动物的名称，只包括数量大于零的动物
   */
  List<String> getAnimalBy(int spotter, int period);

  /**
   * @param animal
   * @param period
   * @return 在该特定日期看到该动物的观察者
   */
  List<Integer> getSpotterBy(String animal, int period);

}
