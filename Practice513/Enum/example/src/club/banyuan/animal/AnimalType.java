package club.banyuan.animal;

public class AnimalType {

    public static final AnimalType TIGER = new AnimalType("老虎");
    public static final AnimalType LION = new AnimalType("狮子");
    public static final AnimalType ELEPHANT = new AnimalType("大象");

    private final String typeName;
    // TODO 对code进行初始化，1 表示老虎，2表示狮子，3表示大象
    private final int code;

    private AnimalType(String typeName) {
        switch (typeName) {
            case "老虎":
                this.code = 1;
                break;
            case "狮子":
                this.code = 2;
                break;
            case "大象":
                this.code = 3;
                break;
            default:
                this.code = 0;                          //乱输入时，code == 0；
                break;
        }
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getCode() {
        return code;
    }

    // TODO
    public static AnimalType valueOf(int code) {
        switch(code){
            case 1:return TIGER;
            case 2:return LION;
            case 3:return ELEPHANT;
        }
        return null;
    }

    // TODO
    public static AnimalType valueOf(String typeName) {
        switch (typeName){
            case "老虎":
                return TIGER;
            case "狮子":
                return LION;
            case "大象":
                return ELEPHANT;
            default:
                System.out.println(" 请输出正确的名字！");
                return null;
        }

    }

    @Override
    public String toString() {
        return this.typeName;
    }
}
