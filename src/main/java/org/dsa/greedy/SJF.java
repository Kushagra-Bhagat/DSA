package org.dsa.greedy;

import java.util.Arrays;

// return avg wait time = sum of all wait times / no of processes
public class SJF {

    public static void main(String[] args) {


        int[] process = {4, 3, 7, 1, 2};

        System.out.println(avgWaitTime(process));
    }

    public static int avgWaitTime(int[] process) {

        int wait = 0;
        int time = 0;
        int n = process.length;

        Arrays.sort(process);

        for (int i = 0; i < n; i++) {

            // wait of previous process + time of curr process
            wait += time;
            time += process[i];
        }

        return wait / n;
    }
}
