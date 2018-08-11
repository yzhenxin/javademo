package cn.example.json;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisDemo {
	
	private Jedis jedis;
	private JedisPool jedisPool;
	private ShardedJedis shardedJedis;
	private ShardedJedisPool shardedJedisPool;
	
	public RedisDemo() {
        initialPool();
        initialShardedPool();
        shardedJedis = shardedJedisPool.getResource(); 
        jedis = jedisPool.getResource();
	}
	
	private void initialShardedPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setMaxWaitMillis(10000);
		config.setTestOnBorrow(true);
		
	      // slave链接 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
        shards.add(new JedisShardInfo("127.0.0.1", 6379, "master"));
        shardedJedisPool = new ShardedJedisPool(config, shards);
	}

	private void initialPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setMaxWaitMillis(10000);
		config.setTestOnBorrow(true);
		
		jedisPool = new JedisPool(config, "127.0.0.1", 6379);
	}
	
	public void destroy() {
		jedisPool.close();
		shardedJedisPool.close();
	}
	
	public String set(String key, String value) {
		return jedis.set(key, value);
	}
	
	public String set(String key, Object value) throws Exception {
		JSONObject jsonObject = GoogleDemo.anaylseObj(value);
		return jedis.set(serialize(key), serialize(jsonObject.toJSONString()));
	}
	
	public String get(String key) throws Exception {
		return reSerialize(jedis.get(serialize(key))).toString();
	}
	
	public static byte[] serialize(Object obj) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		oos.close();
		baos.close();
		return baos.toByteArray();
	}
	
	public static Object reSerialize(byte[] bs) throws ClassNotFoundException, IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(bs);
		ObjectInputStream ois = new ObjectInputStream(bais);
		ois.close();
		bais.close();
		return ois.readObject();
	}
	
	public static void main(String[] args) {
		RedisDemo rd = new RedisDemo();
//		System.out.println(rd.set("one", "one"));
/*		JsonUser user = new JsonUser();
		user.setAddress("上海");
		user.setAge(20);
		user.setBirth(new Date());
		user.setName("你好");
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("music");
		hobbies.add("football");
		user.setHobbies(hobbies);
		try {
			System.out.println(rd.set("user", user));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			System.out.println(rd.get("user"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		rd.destroy();
	}
}
