package org.basic.interfaces;

public class OperateNumbers{
    public static void main(String[] args) {
        Operate add = (a, b) -> a + b;
        Operate subtract = (a, b) -> a - b;

        System.out.println(add.operate(1,2));
        System.out.println(subtract.operate(2,1));
    }
}
