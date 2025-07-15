package lv3;

import java.util.*;

// T라고 하면 뭐든 다 들어올 수 있는데, 계산기니까 넘버만 들어올 수 있게
public class ArithmeticCalculator<T extends Number> {
    private T a, b;
    char operator;
    private final List<Double> arrayList =  new ArrayList<>();

    ArithmeticCalculator(char operator, T a, T b) {
        this.operator = operator;
        this.a = a;
        this.b = b;
    }

    private double result;
    public void calculate (){
        switch (OperatorType.getOperator(operator)) {
            case PLUS:
                result = a.doubleValue() + b.doubleValue();
                break;
            case MINUS:
                result = a.doubleValue() - b.doubleValue();
                break;
            case MULTIPLY:
                result = a.doubleValue() * b.doubleValue();
                break;
            case DIVIDE:
                if(b.intValue() == 0) throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");

                result = a.doubleValue() / b.doubleValue();
                break;
            default:
                throw new IllegalArgumentException("오류: 정확히 입력해주세요.");
        }
        arrayList.add(result);
    }

    public void getLargerResult(T n) {
        arrayList.stream()
                 .filter(num -> num > n.doubleValue())
                 .forEach(System.out::println);
    }

    public double getLatestResult() {
        return arrayList.get(arrayList.size() - 1);
    }

    public void removeResult() {
        arrayList.remove(result);
    }
}
