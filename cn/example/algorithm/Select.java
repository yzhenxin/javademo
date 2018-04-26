package cn.example.algorithm;

public class Select {
	public static void select(int[] arr) {
		int len = arr.length;
		int k = 0, tmp = 0;

		for (int i = 0; i < len; i++) {
			k = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[k] > arr[j])
					k = j;
			}
			if (k != i) {
				tmp = arr[k];
				arr[k] = arr[i];
				arr[i] = tmp;
			}
			System.out.print((i + 1) + " : ");
			Utils.print(arr);
		}
	}

	public static void main(String[] args) {
		int[] arr = Utils.getRandomArr(15, 50);
		Utils.print(arr);
		select(arr);
		Utils.print(arr);
	}
}
