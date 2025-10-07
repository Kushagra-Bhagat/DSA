package org.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Time {
    int start;
    int end;
    int pos;

    public Time(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

public class Meetings {
    public static void main(String[] args) {

        int[] start = {0, 3, 1, 5, 5, 8};
        int[] end = {5, 4, 2, 9, 7, 9};

        System.out.println("Max no of meetings: " + maxMeetings(start, end));
    }

    public static int maxMeetings(int[] start, int[] end) {

        int n = start.length;
        Time[] time = new Time[n];

        for (int i = 0; i < n; i++) {
            time[i] = new Time(start[i], end[i], i);
        }

        Arrays.sort(time, Comparator.comparingInt(x -> x.end));

        int freeTime = 0;
        int count = 0;
        List<Integer> meeting = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // here we can only start a meeting after finish time of previous meeting
            if (time[i].start > freeTime) {
                freeTime = time[i].end;
                count++;
                meeting.add(time[i].pos + 1);
            }
        }

        System.out.println("Order of meetings: " + Arrays.toString(meeting.toArray()));

        return count;
    }
}
