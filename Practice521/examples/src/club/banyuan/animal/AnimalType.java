package club.banyuan.animal;

public enum AnimalType {
  ELEPHANT("大象", 3),
  LION("狮子", 2),
  TIGER("老虎", 1);

  private final String typeName;
  private final int code;

  AnimalType(String typeName, int code) {
    this.typeName = typeName;
    this.code = code;
  }

  @Override
  public String toString() {
    return this.typeName;
  }

  public static AnimalType valueOfTypeName(String typeName) {
    AnimalType[] values = values();

    for (AnimalType one : values) {
      if (one.typeName.equals(typeName)) {
        return one;
      }
    }
    return valueOf(typeName);
  }

  public static AnimalType valueOf(int code) {
    AnimalType[] values = values();
    for (AnimalType one : values) {
      if (one.code == code) {
        return one;
      }
    }
    return null;
  }

  public String getTypeName() {
    return typeName;
  }

  public int getCode() {
    return code;
  }
}
