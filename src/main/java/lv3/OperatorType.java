package lv3;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char operator;

    // enum 생성자
    OperatorType(char operator) {
        this.operator = operator;
    }

    public static OperatorType getOperator(char operator) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.operator == operator) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException("옳바르지 않은 연산자 입니다.");
    }

    public static boolean isValidOperator(char input) {
        for (OperatorType op : OperatorType.values()) {
            if (op.operator == input) {
                return true;
            }
        }
        return false;
    }
}

//public enum OperatorType {
//    PLUS("+", (a, b) -> a + b),
//    MINUS("-", (a, b) -> a - b),
//    MULTIPLY("*", (a, b) -> a * b),
//    DIVIDE("/", (a, b) -> {
//        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
//        return a / b;
//    });
//
//    private final String operator;
//    private final BiFunction<T, U, R> biFunction;
//
//    // enum 생성자
//    OperatorType(String operator, BiFunction<T, U, R> biFunction) {
//        this.operator = operator;
//        this.biFunction = biFunction;
//    }
//
//    public String getOperator() {
//        return operator;
//    }
//}