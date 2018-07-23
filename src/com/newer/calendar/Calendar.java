package com.newer.calendar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {

		int year;
		int month = 0;
		boolean inrun = false;
		int totalDays = 0;
		int days = 0;
		int weeks;

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份");
		year = sc.nextInt();
		while (year <= 1900) {
			System.out.println("所输年份有误，请重新输入");
			year = sc.nextInt();
		}
		System.out.println("请输入月份");

		try {
			month = sc.nextInt();
			while (month < 1 || month > 12) {
				System.out.println("所输月份有误，请重新输入");
				month = sc.nextInt();
			}
		} catch (InputMismatchException e) {
			month = sc.nextInt();
		}

		if (year % 400 == 0 || (year % 4 == 0 && (year % 100 != 0))) {
			inrun = true;
		}
		// 获取所输入年份之前的总天数
		for (int i = 1900; i < year; i++) {
			if (i % 400 == 0 || (i % 4 == 0 && (year % 100 != 0))) {
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}

		// 获取所输入月份在当年之前的总天数
		for (int i = 1; i <= month; i++) {
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 2:
				if (inrun == true) {
					days = 29;
				} else {
					days = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			default:
				;
			}
			if (i != month) {
				totalDays += days;
			}
		}
		weeks = totalDays % 7;

		System.out.println("星期天\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		for (int j = 0; j < weeks; j++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= days; i++) {
			System.out.print(i + "\t");
			if ((i + weeks) % 7 == 0) {
				System.out.println();
			}
		}
	}

}
