package cn.example.algorithm;

public class Insert {
	public static void insert(int[] arr) {
		int len = arr.length;
		int k = 0, tmp = 0;
		for (int i = 1; i < len; i++) {
			k = i - 1;
			tmp = arr[i];
			while (k >= 0 && tmp < arr[k]) {
				arr[k + 1] = arr[k];
				k--;
			}
			arr[k+1] = tmp;
		}
	}
	public static void main(String[] args) {
		int[] arr = Utils.getRandomArr(15, 50);
		Utils.print(arr);
		insert(arr);
		Utils.print(arr);
	}
}
