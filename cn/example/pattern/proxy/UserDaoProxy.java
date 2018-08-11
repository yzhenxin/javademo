package cn.example.pattern.proxy;

/**
 * 代理对象
 * @author yzx
 *
 */
public class UserDaoProxy implements IUserDao {
	
	private IUserDao target;

	public UserDaoProxy(IUserDao target) {
		this.target = target;
	}
	
	@Override
	public void save() {
		System.out.println("事务begin");
		target.save();
		System.out.println("事务end");
	}
	
	

}
