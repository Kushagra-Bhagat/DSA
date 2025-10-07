package org.dsa.greedy;

// for 20 -> u wanna discard 10 bill first be greedy
public class LemonadeChange {
    public static void main(String[] args) {

        int[] sale = {5, 5, 10, 10, 20};

        System.out.println(canSell(sale));
    }

    public static boolean canSell(int[] sale) {

        int five = 0;
        int ten = 0;
        int twenty = 0;
        int n = sale.length;

        for (int i = 0; i < n; i++) {
            if (sale[i] == 5) {
                five++;
            }
            else if (sale[i] == 10) {
                if (five >= 1) {
                    five--;
                    ten++;
                }
                else {
                    return false;
                }
            }
            else if (sale[i] == 20) {
                if (ten >= 1 && five >= 1) {
                    five--;
                    ten--;
                    twenty++;
                }
                else if (five >= 3) {
                    five = five - 3;
                    twenty++;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
