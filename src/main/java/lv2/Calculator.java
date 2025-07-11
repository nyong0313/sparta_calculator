package lv2;

import java.util.ArrayList;

public class Calculator {
    int a, b, result = 0;
    char operator;
    ArrayList<Integer> arrayList =  new ArrayList<>();

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

    public void calculate () throws ArithmeticException, Exception {
        switch (operator) {
            case '+':
                result = a + b;
                arrayList.add(result);
                break;
            case '-':
                result = a - b;
                arrayList.add(result);
                break;
            case '*':
                result = a * b;
                arrayList.add(result);
                break;
            case '/':
                if(b == 0) throw new ArithmeticException();

                result = a / b;
                arrayList.add(result);
                break;
            default:
                throw new Exception();
        }
    }

    public void removeResult() {
        result = arrayList.remove(result);
    }
}
