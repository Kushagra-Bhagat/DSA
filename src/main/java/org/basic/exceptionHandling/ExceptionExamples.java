package org.basic.exceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

// throws -> tells us there is an exception somewhere use a catch block to handle it
// or it will be handled by JVM
public class ExceptionExamples {
    public static void main(String[] args) throws FileNotFoundException{
        method1();
    }

    static void method1() throws FileNotFoundException{
        method2();
    }

    static void method2() throws FileNotFoundException{
        try {
            FileReader file = new FileReader("a.txt");
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        method3();

        //  to throw an exception of our choice and message
        throw new FileNotFoundException("oops");
    }

    // here no error for throw because we use unchecked exception
    static void method3() {
        throw new ArithmeticException();
    }
}
