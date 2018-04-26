package cn.example.algorithm;

public class Quick {
	public static int count = 1;
	public static int inner(int[] arr, int start, int end) {
		int lindex = start, rindex = end;
		int standard = arr[start];
		while (lindex < rindex) {
			while (lindex < rindex && standard <= arr[rindex]) {
				rindex--;
			}
			arr[lindex] = arr[rindex];
			while (lindex < rindex && standard >= arr[lindex]) {
				lindex++;
			}
			arr[rindex] = arr[lindex];
		}
		arr[lindex] = standard;
		return lindex;
	}

	public static void quick(int[] arr, int start, int end) {
		System.out.println(" s : " + start + " e: " + end);
		if (start >= end) {
			return;
		}
		int inner = inner(arr, start, end);
		System.out.print(inner + " : ");
		Utils.print(arr);
/*		for (int i = 0, ii = end; i <= ii; i++) {
			System.out.format("%-4d", arr[i]);
		}
		System.out.println();*/
		quick(arr, start, inner - 1);
		quick(arr, inner + 1, end);
	}

	public static void main(String[] args) {
		int[] arr = Utils.getRandomArr(8, 100);
		Utils.print(arr);
		quick(arr, 0, arr.length - 1);
		Utils.print(arr);
	}
}
