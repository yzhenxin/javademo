package cn.example.pattern.singleton;

public class SingletonHungry {
	private static SingletonHungry instance = new SingletonHungry();

	private SingletonHungry() {
	}

	public static SingletonHungry getInstance() {
		return instance;
	}

	public void showMsg() {
		System.out.println("Hello Singleton Pattern.");
	}
}
