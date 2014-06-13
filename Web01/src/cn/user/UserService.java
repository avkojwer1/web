package cn.user;

public class UserService {
	//ÉùÃ÷Á½¸ödao
	private UserDao1 dao1 = new UserDao1();
	private UserDao2 dao2 = new UserDao2();

	public void save(){
		dao1.save();
		dao2.save();
	}
}
