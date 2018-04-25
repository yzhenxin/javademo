package cn.example.pattern.singleton;

public class SingletonLazySyn {
	private static SingletonLazySyn instance;

	private SingletonLazySyn() {
	}

	public static synchronized SingletonLazySyn getInstance() {
		if (instance == null) {
			instance = new SingletonLazySyn();
		}
		return instance;
	}

	public void showMsg() {
		System.out.println("Hello Singleton Pattern.");
	}
}
