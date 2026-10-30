class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class Main {

    static void test(String name, int expected, int actual) {
        if (expected == actual) {
            System.out.println(name + ": PASS");
        } else {
            System.out.println(name + ": FAIL");
        }
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        test("Addition Test", 10, calc.add(5, 5));
        test("Subtraction Test", 5, calc.subtract(10, 5));
        test("Multiplication Test", 20, calc.multiply(4, 5));
        test("Division Test", 5, calc.divide(10, 2));

        try {
            calc.divide(10, 0);
            System.out.println("Division by Zero Test: FAIL");
        } catch (ArithmeticException e) {
            System.out.println("Division by Zero Test: PASS");
        }
    }
}

OUTPUT:
Addition Test: PASS
Subtraction Test: PASS
Multiplication Test: PASS
Division Test: PASS
Division by Zero Test: PASS
