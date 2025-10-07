package org.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduling {
    public static void main(String[] args) {

        Job j1 = new Job(1, 4, 40);
        Job j2 = new Job(2, 1, 10);
        Job j3 = new Job(3, 1, 40);
        Job j4 = new Job(4, 1, 30);

        Job[] arr = {j1, j2, j3, j4};

        System.out.println("profit: " + sum(arr));
    }

    public static int sum(Job[] arr) {

        Arrays.sort(arr, Comparator.comparingInt(x -> -x.profit));

        int n = arr.length;
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        int[] days = new int[maxDeadline + 1];
        Arrays.fill(days, -1);
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            int id = arr[i].id;
            int deadline = arr[i].deadline;
            int profit = arr[i].profit;

            if (days[deadline] == -1) {
                days[deadline] = id;
                totalProfit += profit;
            }
            else {
                for (int k = deadline - 1; k > 0; k--) {
                    if (days[k] == -1) {
                        days[k] = id;
                        totalProfit += profit;
                        break;
                    }
                }
            }
        }

        System.out.println("job: " + Arrays.toString(days));

        return totalProfit;
    }
}
