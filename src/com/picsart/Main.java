package com.picsart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int hour = 0;
        int minute = 0;
        int second = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please set time HH:MM:SS");
        String time = scanner.nextLine();
        if (!time.matches("^([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$")) {
            System.out.println("Time is incorrect");
        } else {
            hour = Integer.parseInt(time.substring(0, 2));
            minute = Integer.parseInt(time.substring(3, 5));
            second = Integer.parseInt(time.substring(6));
        }
        //print time
        if (hour == 0 && minute == 0 && second == 0) {
            print(hour, minute, second);
        } else {
            showTime(hour, minute, second);
        }
    }

    private static void showTime(int hour, int minute, int second) {
        do {
            if (second == 0) {
                if (minute == 0) {
                    hour--;
                    minute = 59;
                } else {
                    minute--;
                }
                second = 59;
            } else {
                second--;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print(hour, minute, second);
        } while (hour != 0 || minute != 0 || second != 0);
    }

    private static void print(int hour, int minute, int second) {
        StringBuilder stringBuilder = new StringBuilder();
        if (hour < 10) {
            stringBuilder.append("0").append(hour).append(":");
        } else {
            stringBuilder.append(hour).append(":");
        }
        if (minute < 10) {
            stringBuilder.append("0").append(minute).append(":");
        } else {
            stringBuilder.append(minute).append(":");
        }
        if (second < 10) {
            stringBuilder.append("0").append(second);
        } else {
            stringBuilder.append(second);
        }
        System.out.println(stringBuilder.toString());
    }
}
