package club.banyuan;

public interface Timer {

  /**
   * 开始计时，开始计时后，自动重置时间
   *
   * @throws IllegalStateException 如果已经开始计时后没有停止计时，然后再次调用开始计时方法，抛出此异常
   */
  void start() throws IllegalStateException;

  /**
   * 停止计时
   *
   * @throws IllegalStateException 如果没有开始开始计时调用停止计时方法，抛出此异常
   */
  void stop() throws IllegalStateException;

  /**
   * 重置时间
   */
  void reset();

  /**
   * 返回开始时间到结束时间花费的毫秒值
   *
   * @return
   */
  long getTimeMillisecond();
}
