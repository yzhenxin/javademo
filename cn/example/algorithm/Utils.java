package cn.example.algorithm;

import java.util.Random;

public class Utils {
	public static int[] getRandomArr(int len, int maxVal) {
		int[] arr = new int[len];
		Random rand = new Random(System.currentTimeMillis());
		for(int i = 0; i < len; i++) {
			arr[i] = rand.nextInt(maxVal) + 1;
		}
		return arr;
	}
	public static void print(int[] arr) {
		for(int i = 0, ii = arr.length; i < ii; i++) {
			System.out.format("%-4d", arr[i]);
		}
		System.out.println();
	}
	public static <T> void print(T[] arr) {
		for(int i = 0, ii = arr.length; i < ii; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}
}
