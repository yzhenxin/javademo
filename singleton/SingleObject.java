package singleton;

public class SingleObject {
	private static SingleObject instance = new SingleObject();

	private SingleObject() {
	}

	public static SingleObject getInstance() {
		return instance;
	}

	public void showMsg() {
		System.out.println("Hello Singleton Pattern.");
	}
	
	public static void main(String[] args) {
//		SingleObject so = new SingleObject();
		SingleObject so = SingleObject.getInstance();
		so.showMsg();
	}
}
