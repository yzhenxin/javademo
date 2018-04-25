package cn.example.pattern.singleton;

public class SingletonLazy {
	private static SingletonLazy instance;

	private SingletonLazy() {
	}

	public static SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}

	public void showMsg() {
		System.out.println("Hello Singleton Pattern.");
	}
}
