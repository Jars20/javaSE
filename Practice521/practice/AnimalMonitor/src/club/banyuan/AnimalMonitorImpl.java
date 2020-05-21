package club.banyuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 监视不同种类动物的数量。由观察者记录目击事件。
 */
public class AnimalMonitorImpl implements AnimalMonitor {

  // 记录所有发现的动物。
  private List<Sighting> sightings;

  /**
   * 创建一个AnimalMonitor。
   */
  public AnimalMonitorImpl() {
    this.sightings = new ArrayList<>();
  }


  /**
   * 打印所有目击动物的详细信息。
   */
  @Override
  public void printList() {
    sightings.forEach(sighting -> System.out.println(sighting.getDetails()));
  }


  /**
   * 打印给定动物的所有目击细节。
   *
   * @param animal 动物的类型。
   */
  @Override
  public void printSightingsOf(String animal) {
    sightings.forEach(sighting -> {
      if (sighting.getAnimal().equals(animal)) {
        System.out.println(sighting.getDetails());
      }
    });
  }

  /**
   * 打印给定观察者的所有目击动物。
   *
   * @param spotter 观察者的ID。
   */
  @Override
  public void printSightingsBy(int spotter) {
    Set<String> spotterAnimal = new HashSet<>();
    sightings.forEach(sighting -> {
      if (sighting.getSpotter() == spotter) {
        spotterAnimal.add(sighting.getAnimal());
      }
    });
    System.out.println(new LinkedList<>(spotterAnimal));
  }

  /**
   * 打印一份被视为濒临灭绝的动物的清单。
   *
   * @param animalNames     动物名称列表。
   * @param dangerThreshold 小于或等于此级别的动物总数被认为濒临灭绝的
   */
  @Override
  public void printEndangered(List<String> animalNames, int dangerThreshold) {
    animalNames.forEach(animalName -> {
      int num = dangerThreshold;
      for (Sighting sighting : sightings) {
        if (sighting.getAnimal().equals(animalName)) {
          num += sighting.getCount();
        }
      }
      if (num < dangerThreshold) {
        System.out.println(animalName + "是濒临灭绝的动物！");
      }
    });
  }


  /**
   * 打印在特定期间periodID内记录的所有目击事件的详细信息，并将其作为参数传递给该方法
   *
   * @param period 日期ID
   * @return 指定日期的清单
   */
  @Override
  public List<Sighting> printSightingsInPeriod(int period) {
    List<Sighting> output = new ArrayList<>();
    sightings.forEach(sighting -> {
      if (sighting.getPeriod() == period) {
        output.add(sighting);
      }
    });
    return output;
  }

  /**
   * 打印并返回指定日期区间内的清单
   *
   * @param fromPeriod 日期开始
   * @param toPeriod   日期结束
   * @param animal     动物类型
   */
  @Override
  public List<Sighting> printSightingsOfInPeriod(int fromPeriod, int toPeriod, String animal) {
    List<Sighting> output = new ArrayList<>();
    sightings.forEach(sighting -> {
      if (sighting.getPeriod() < toPeriod && sighting.getPeriod() > fromPeriod && sighting
          .getAnimal().equals(animal)) {
        output.add(sighting);
      }
    });
    return output;
  }

  /**
   * 打印特定动物类型的总的目击数量
   *
   * @param animal 动物类型
   */
  @Override
  public List<Sighting> printCounts(String animal) {
    List<Sighting> output = new ArrayList<>();
    sightings.forEach(sighting -> {
      if (sighting.getAnimal().equals(animal)) {
        output.add(sighting);
      }
    });
    return output;
  }

  /**
   * 返回给定动物目击次数。
   *
   * @param animal 动物的类型。
   * @return 给定动物的目击次数总数。
   */
  @Override
  public int getCount(String animal) {
    int num = 0;
    for (Sighting sighting : sightings) {
      if (sighting.getAnimal().equals(animal)) {
        num++;
      }
    }
    return num;
  }

  /**
   * 从发现清单中删除计数为零的记录。
   */
  @Override
  public void removeZeroCounts() {
    sightings.removeIf(sighting -> sighting.getCount() == 0);
  }

  /**
   * 返回特定区域内给定类型的动物的所有动物清单。
   *
   * @param animal 动物的类型。
   * @param area   区域的ID。
   * @return 目击清单。
   */
  @Override
  public List<Sighting> getSightingsInArea(String animal, int area) {
    List<Sighting> output = new ArrayList<>();
    for (Sighting sighting : sightings) {
      if (sighting.getAnimal().equals(animal) && sighting.getArea() == area) {
        output.add(sighting);
      }
    }
    return output;
  }

  /**
   * 返回给定动物的所有目击清单。
   *
   * @param animal 动物的类型。
   * @return 给定动物的所有目击物清单。
   */
  @Override
  public List<Sighting> getSightingsOf(String animal) {
    List<Sighting> output = new ArrayList<>();
    for (Sighting sighting : sightings) {
      if (sighting.getAnimal().equals(animal)) {
        output.add(sighting);
      }
    }
    return output;
  }

  /**
   * @param spotter
   * @param period
   * @return 包含该观察者在特定日期看到的动物的名称，只包括数量大于零的动物
   */
  @Override
  public List<String> getAnimalBy(int spotter, int period) {
    List<String> output = new ArrayList<>();
    for (Sighting sighting : sightings) {
      if (sighting.getSpotter() == spotter && sighting.getPeriod() == period
          && sighting.getCount() > 0) {
        output.add(sighting.getAnimal());
      }
    }
    return output;
  }

  /**
   * @param animal
   * @param period
   * @return 在该特定日期看到该动物的观察者
   */
  @Override
  public List<Integer> getSpotterBy(String animal, int period) {
    List<Integer> output = new ArrayList<>();
    for (Sighting sighting : sightings) {
      if (sighting.getAnimal().equals(animal) && sighting.getPeriod() == period
          && sighting.getCount() > 0) {
        output.add(sighting.getSpotter());
      }
    }
    return output;
  }

}
