package lv3;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            double[] inputNumber = new double[3];
            Arrays.fill(inputNumber, -1);

            try{
                for (int i = 1; i <= 2; i++) {
                    while(inputNumber[i] < 0){
                        System.out.println(i + " 번째 숫자를 입력하세요.");
                        inputNumber[i] = sc.nextDouble();
                    }
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("사칙연산 기호를 입력하세요. ex) +, -, *, /");
            char operator = sc.next().charAt(0);
            if (!OperatorType.isValidOperator(operator)) {
                System.out.println("옳바르지 않은 연산자입니다.");
                continue;
            }

            ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>(operator, inputNumber[1], inputNumber[2]);
            try {
                arithmeticCalculator.calculate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println(arithmeticCalculator.getLatestResult());

            try {
                System.out.println("저장한 값 중 다음 값보다 큰 결과값 출력");
                arithmeticCalculator.getLargerResult(sc.nextDouble());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.next();
            if (answer.equals("exit")) {
                break;
            }
        }

        sc.close();
    }
}
