package lv3;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char operator;

    // enum 생성자 (실제로 쓸일은 없지만 내부적으로 사용됨)
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