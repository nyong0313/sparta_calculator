package lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            try {
                int a = -1;
                while (a < 0) {
                    System.out.println("첫 번째 숫자를 입력하세요.");
                    a = sc.nextInt();
                }
                calculator.setA(a);

                int b = -1;
                while (b < 0) {
                    System.out.println("두 번째 숫자를 입력하세요.");
                    b = sc.nextInt();
                }
                calculator.setB(b);

                System.out.println("사칙연산 기호를 입력하세요. ex) +, -, *, /");
                char operator = sc.next().charAt(0);
//          char c = sc.nextLine().charAt(0);
                calculator.setOperator(operator);
                calculator.calculate();
                System.out.println(calculator.getResult());
                
                System.out.println("첫 번째 저장값을 삭제하시겠습니까? (Y/N)");
                char ansRemove = sc.next().charAt(0);
                if (ansRemove == 'Y') calculator.removeResult();
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
            catch (Exception e) {
                System.out.println("오류: 정확히 입력해주세요.");
                sc.next();
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
