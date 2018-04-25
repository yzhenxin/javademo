package cn.example.pattern.singleton;

public class SingletonPatternDemo {
	public static void main(String[] args) {
		SingleObject.getInstance().showMsg();
		SingletonDCL.getInstance().showMsg();
		SingletonHungry.getInstance().showMsg();
		SingletonLazy.getInstance().showMsg();
		SingletonLazySyn.getInstance().showMsg();
	}
}
