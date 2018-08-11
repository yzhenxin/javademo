package cn.example.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	private Object target;
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("begin transaction");
						Object result = method.invoke(target, args);
						System.out.println("transaction end");
						return result;
					}
				}); 
	}
	
	
	public static void main(String[] args) {
		IUserDao dao = new IUserDaoImpl();
		System.out.println(dao.getClass());
		
		IUserDao proxy = (IUserDao) new ProxyFactory(dao).getProxyInstance();
		System.out.println(dao.getClass());
		proxy.save();
	}
}
