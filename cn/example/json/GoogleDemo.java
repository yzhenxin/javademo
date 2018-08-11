package cn.example.json;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.commons.logging.impl.SimpleLog;
import org.apache.log4j.spi.LoggerFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GoogleDemo {
	public static void main1(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("name", "map name");
		map.put("address", "啥那hi");
		JSONObject jo = new JSONObject(map);
		System.out.println(jo.toString());
		Object object = jo.get("name");
		System.out.println(object);
		
		System.out.println(jo.toJSONString());
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		JSONArray ja = new JSONArray();
		boolean addAll = ja.addAll(list);
		System.out.println(ja.toJSONString());
		
		jo.put("list", list);
		
		System.out.println(jo.toJSONString());
		List<String> la = (List<String>) jo.get("list");
		la.add("new");
		System.out.println(jo.toJSONString());
		
		System.out.println(upFirstWord("anwo"));
		
	}
	
	public static void main(String[] args) {
		try {
/*			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(new File("E:/oracle.png")));
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(new File("E:/new.png")));*/
			
//			FileUtils.copyFile(new File("E:/oracle.png"), new File("E:/new.png"));
			File file = new File("E:/oracle.png");
			System.out.println(file.getCanonicalPath());
			System.out.println(file.getParentFile());
			System.out.println(file.getParentFile().mkdirs());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main2(String[] args) {
		List<JsonUser> users = new ArrayList<>();
		JsonUser user = new JsonUser();
		user.setAddress("上海");
		user.setAge(20);
		user.setBirth(new Date());
		user.setName("你好");
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("music");
		hobbies.add("football");
		user.setHobbies(hobbies);
		JsonUser user1 = new JsonUser();
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
		
		JSONArray ja = new JSONArray();
		try {
			for(JsonUser u : users) {
				JSONObject anaylseObj = anaylseObj(user);
				System.out.println(anaylseObj.toString());
				List<String> ls = new ArrayList<>();
				System.out.println(ls.getClass().getName());
				ja.add(anaylseObj);
			}
			System.out.println(ja.toJSONString());
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static <T extends Object> JSONObject anaylseObj(T obj) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<? extends Object> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		JSONObject jo = new JSONObject();
		for(Field f : fields) {
			f.setAccessible(true);
			String fieldName = f.getName();
			String methodName = "get" + upFirstWord(fieldName);
			System.out.println("method " + methodName);
			Method method = clazz.getMethod(methodName, new Class<?>[] {});
			Object invoke = method.invoke(obj);
			System.out.println("field = " + fieldName + " | value = " + invoke);
			jo.put(fieldName, invoke);
		}
		return jo;
	}
	
	public static String upFirstWord(String field) {
		if(field == null && "".equals(field)) {
			return null;
		}
		char[] cs = field.toCharArray();
		cs[0] -= 32;
		return new String(cs);
	}
	
}
