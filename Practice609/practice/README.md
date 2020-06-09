编写一个方法打印传入对象的类的所有方法和成员变量。例如传入一个Integer打印内容如下，方法和成员变量分别按照名称升序排列打印

```
  public static void main(String[] args) {
    printInfo(0);
  }
  /**
   * 接收一个对象，输出对象类的所有方法和成员，分别按照名称升序排列
   *
   * @param object
   */
  public static void printInfo(Object object)
```

```
public static int java.lang.Integer.bitCount(int)
public byte java.lang.Integer.byteValue()
public static int java.lang.Integer.compare(int,int)
public int java.lang.Integer.compareTo(java.lang.Object)
public int java.lang.Integer.compareTo(java.lang.Integer)
public static int java.lang.Integer.compareUnsigned(int,int)
public static java.lang.Integer java.lang.Integer.decode(java.lang.String) throws java.lang.NumberFormatException
public static int java.lang.Integer.divideUnsigned(int,int)
public double java.lang.Integer.doubleValue()
public boolean java.lang.Integer.equals(java.lang.Object)
public float java.lang.Integer.floatValue()
public final native java.lang.Class java.lang.Object.getClass()
public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,java.lang.Integer)
public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,int)
public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String)
public static int java.lang.Integer.hashCode(int)
public int java.lang.Integer.hashCode()
public static int java.lang.Integer.highestOneBit(int)
public int java.lang.Integer.intValue()
public long java.lang.Integer.longValue()
public static int java.lang.Integer.lowestOneBit(int)
public static int java.lang.Integer.max(int,int)
public static int java.lang.Integer.min(int,int)
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()
public static int java.lang.Integer.numberOfLeadingZeros(int)
public static int java.lang.Integer.numberOfTrailingZeros(int)
public static int java.lang.Integer.parseInt(java.lang.String) throws java.lang.NumberFormatException
public static int java.lang.Integer.parseInt(java.lang.String,int) throws java.lang.NumberFormatException
public static int java.lang.Integer.parseInt(java.lang.CharSequence,int,int,int) throws java.lang.NumberFormatException
public static int java.lang.Integer.parseUnsignedInt(java.lang.String,int) throws java.lang.NumberFormatException
public static int java.lang.Integer.parseUnsignedInt(java.lang.CharSequence,int,int,int) throws java.lang.NumberFormatException
public static int java.lang.Integer.parseUnsignedInt(java.lang.String) throws java.lang.NumberFormatException
public static int java.lang.Integer.remainderUnsigned(int,int)
public static int java.lang.Integer.reverse(int)
public static int java.lang.Integer.reverseBytes(int)
public static int java.lang.Integer.rotateLeft(int,int)
public static int java.lang.Integer.rotateRight(int,int)
public short java.lang.Integer.shortValue()
public static int java.lang.Integer.signum(int)
public static int java.lang.Integer.sum(int,int)
public static java.lang.String java.lang.Integer.toBinaryString(int)
public static java.lang.String java.lang.Integer.toHexString(int)
public static java.lang.String java.lang.Integer.toOctalString(int)
public static java.lang.String java.lang.Integer.toString(int)
public static java.lang.String java.lang.Integer.toString(int,int)
public java.lang.String java.lang.Integer.toString()
public static long java.lang.Integer.toUnsignedLong(int)
public static java.lang.String java.lang.Integer.toUnsignedString(int,int)
public static java.lang.String java.lang.Integer.toUnsignedString(int)
public static java.lang.Integer java.lang.Integer.valueOf(int)
public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String,int) throws java.lang.NumberFormatException
public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String) throws java.lang.NumberFormatException
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public static final int java.lang.Integer.BYTES
static final byte[] java.lang.Integer.DigitOnes
static final byte[] java.lang.Integer.DigitTens
public static final int java.lang.Integer.MAX_VALUE
public static final int java.lang.Integer.MIN_VALUE
public static final int java.lang.Integer.SIZE
public static final java.lang.Class java.lang.Integer.TYPE
static final char[] java.lang.Integer.digits
private static final long java.lang.Integer.serialVersionUID
static final int[] java.lang.Integer.sizeTable
private final int java.lang.Integer.value
```