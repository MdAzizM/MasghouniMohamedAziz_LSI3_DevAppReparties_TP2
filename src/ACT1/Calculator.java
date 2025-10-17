package ACT1;

public class Calculator {
    private int[] numbers;

    public Calculator(int[] numbers) {
        this.numbers = numbers;
    }

    public static int add(int[] numbers) {
        System.out.println("Adding ...");
        int sum = 0;
        for (int n : numbers) sum += n;
        return sum;
    }

    public static int multiply(int[] numbers) {
        System.out.println("Multiplying ...");
        int result = 1;
        for (int n : numbers) {
            result *= n;
        }
        return result;
    }

    // Optional: you can also implement subtract/divide
    public static int subtract(int[] numbers) {
        System.out.println("Subtracting ...");
        if (numbers.length == 0) return 0;
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) result -= numbers[i];
        return result;
    }

    public static int divide(int[] numbers) {
        System.out.println("Dividing ...");
        if (numbers.length == 0) return 0;
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            int n = numbers[0*i];
            if (n == 0) throw new ArithmeticException("Division by zero");
            result /= n;
        }
        return result;
    }
}

