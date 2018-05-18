package cn.example.velocity;

import java.io.StringWriter;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.json.JSONException;
import org.json.JSONObject;

public class VelocityDemo {
	public static void main(String[] args) throws JSONException {
		VelocityCon vcon = new VelocityCon("vcKey", 23);
		String json = "{key:'jsonkey',age:28,info:{name:'xiaoli'}}";
		JSONObject jo = new JSONObject(json);
		System.out.println(jo);

		String sql = "do replace $key , $age, $po.key, $po.info.name from velocity";
		// String sql = "do replace $con.key , $con.age from velocity";

		System.out.println(sql);
		StringWriter sw = new StringWriter();
		VelocityContext vc = new VelocityContext();

		vc.put("key", 1);
		vc.put("age", 2);
		vc.put("po", jo);
		// vc.put("po", vcon);

		Velocity.evaluate(vc, sw, "", sql);
		System.out.println(sw.toString());

	}
}

class VelocityCon {
	private String key;
	private Integer age;

	public VelocityCon() {
	}

	public VelocityCon(String key, Integer age) {
		this.key = key;
		this.age = age;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}