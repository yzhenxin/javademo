package cn.example.pattern.proxy;

public class App {
	public static void main(String[] args) {
		IUserDaoImpl target = new IUserDaoImpl();
		UserDaoProxy proxy = new UserDaoProxy(target);
		proxy.save();
	}
}
