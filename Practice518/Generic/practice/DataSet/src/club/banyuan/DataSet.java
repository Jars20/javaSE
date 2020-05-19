package club.banyuan;

public class DataSet<T>{


  private double sum;
  private int count;
  private T maximum;
  private Measurer<T> measurer;

  public DataSet() {
    this.measurer =  new Measurer<T>() {
      @Override
      public double measure(T anObject) {

        return ((Measurable)anObject).getMeasure();
      }
    };
  }

  public DataSet(Measurer<T> aMeasurer) {
    sum = 0;
    count = 0;
    maximum = null;
    measurer = aMeasurer;
  }

  public void add(T x) {
    sum = sum + measurer.measure(x);
    if (count == 0 || measurer.measure(maximum) < measurer.measure(x)) {
      maximum = x;
    }
    count++;
  }


//  private Measurer<T> creatMeasurer() {
//    return
//  }

//  private void addByMeasurer(T x) {
//    sum = sum + measurer.measure(x);
//    if (count == 0 || measurer.measure(maximum) < measurer.measure(x)) {
//      maximum = x;
//    }
//    count++;
//  }

//  private void add(Measurable measurable) {
//    sum = sum + measurable.getMeasure();
//    if (count == 0 || ((Measurable) maximum).getMeasure() < measurable.getMeasure()) {
//      maximum = (T) measurable;
//    }
//    count++;
//  }


  public double getAverage() {
    if (count == 0) {
      return 0;
    }
    return sum / count;
  }

  public T getMaximum() {
    return maximum;
  }


}