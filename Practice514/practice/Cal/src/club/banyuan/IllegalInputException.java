package club.banyuan;

public class IllegalInputException extends CalculatorException {
    //TODO:改进该exception使其exceptionType类似枚举类
    private String exceptionType;

    //get和set
    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;

    }

    //构造方法
    public IllegalInputException(String exceptionType) {
        this.exceptionType = exceptionType;
    }
}
