package cn.example.pattern.proxy;

/**
 * 目标对象
 * @author yzx
 *
 */
public class IUserDaoImpl implements IUserDao {

	@Override
	public void save() {
		System.out.println("----以保存数据----");
	}

}
