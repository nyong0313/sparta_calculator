package lv2;

import java.util.*;

public class Calculator {
    int a, b, result = 0;
    char operator;
    private final List<Integer> arrayList =  new ArrayList<>();

    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int getResult() {
        return result;
    }

    public void calculate () {
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if(b == 0) throw new ArithmeticException();

                result = a / b;
                break;
            default:
                throw new IllegalArgumentException();
        }
        arrayList.add(result);
    }

    public void removeResult() {
        result = arrayList.remove(result);
    }
}
