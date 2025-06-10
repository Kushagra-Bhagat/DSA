package org.basic.exceptionHandling;

public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        int[] numerator = {10, 100, 400, 200};
        int[] denominator = {1, 100, 0, 40};

        for (int i = 0; i < numerator.length; i++) {
            System.out.println(divide(numerator[i], denominator[i]));
        }
    }

    static int divide(int a, int b) {
        try {
            return a / b;
        }
        catch(ArithmeticException | NullPointerException e) {
            // don't need to write .toString() because already defined
            System.out.println(e);
            return -1;
        }
        // it will work even though we have return statements above
        finally {
            System.out.println("Function execution complete after every try-catch");
        }
    }

    // we can use try(object) if we are using resources like file reader to close them
    // works instead of using finally for closing resources
}
