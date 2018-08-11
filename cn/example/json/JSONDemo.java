package cn.example.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		JSONArray ja = new JSONArray(list);
		System.out.println(ja.toString());
		
		Map<String, String> map = new HashMap<>();
		map.put("name", "map name");
		map.put("address", "啥那hi");
		JSONObject jo = new JSONObject(map);
		System.out.println(jo.toString());
		
	}
	
}
