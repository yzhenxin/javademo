package cn.example.serializedemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SerializaTest {
	public static void main(String[] args) {
		List<SerializeUser> users = new ArrayList<>();
		SerializeUser user = new SerializeUser();
		user.setAddress("上海");
		user.setAge(20);
		user.setBirth(new Date());
		user.setName("你好");
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("music");
		hobbies.add("football");
		user.setHobbies(hobbies);
		SerializeUser user1 = new SerializeUser();
		user1.setAddress("上海1");
		user1.setAge(21);
		user1.setBirth(new Date());
		user1.setName("你好1");
		List<String> hobbies1 = new ArrayList<String>();
		hobbies1.add("music1");
		hobbies1.add("football1");
		user1.setHobbies(hobbies1);
		users.add(user);
		users.add(user1);
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(users);
			System.out.println("--- " + baos.toByteArray().length);
			byte[] bytes = baos.toByteArray();
			oos.close();
			baos.close();
			
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			
			Object obj = ois.readObject();
			System.out.println(obj);

			ois.close();
			bais.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		
	}
}
