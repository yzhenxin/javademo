package cn.example.algorithm;

import java.util.Random;

public class Bubble {
	public static void bubble(int[] arr) {
		int len = arr.length - 1;
		int tmp = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0, jj = len - i; j < jj; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}

	public static <T extends Comparable<T>> void bubblig(T[] arr) {
		int len = arr.length - 1;
		T tmp;
		for (int i = 0; i < len; i++) {
			for (int j = 0, jj = len - i; j < jj; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = Utils.getRandomArr(15, 30);
		Utils.print(arr);
		bubble(arr);
		Utils.print(arr);

		Random rand = new Random(System.currentTimeMillis());
		Integer[] arrg = new Integer[10];
		String[] arrs = new String[10];
		for (int i = 0; i < arrg.length; i++) {
			arrg[i] = Integer.valueOf(rand.nextInt(50));
		}
		
		arrs[0] = "abc";
		arrs[1] = "lkjdsf";
		arrs[2] = "ewp";
		arrs[3] = "wer";
		arrs[4] = "dhf";
		arrs[5] = "fdaghf";
		arrs[6] = "fqdagf";
		arrs[7] = "asdlskdfj";
		arrs[8] = "wsladfk";
		arrs[9] = "xlksaf";
		
		Utils.print(arrg);
		bubblig(arrg);
		Utils.print(arrg);
		
		Utils.print(arrs);
		bubblig(arrs);
		Utils.print(arrs);
	}
}
