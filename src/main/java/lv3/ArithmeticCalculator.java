package lv3;

import java.util.*;

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
    public void calculate () throws ArithmeticException, Exception {
        switch (OperatorType.getOperator(operator)) {
            case PLUS:
                result = a.doubleValue() + b.doubleValue();
                arrayList.add(result);
                break;
            case MINUS:
                result = a.doubleValue() - b.doubleValue();
                arrayList.add(result);
                break;
            case MULTIPLY:
                result = a.doubleValue() * b.doubleValue();
                arrayList.add(result);
                break;
            case DIVIDE:
                if(b.intValue() == 0) throw new ArithmeticException();

                result = a.doubleValue() / b.doubleValue();
                arrayList.add(result);
                break;
            default:
                throw new Exception();
        }
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
