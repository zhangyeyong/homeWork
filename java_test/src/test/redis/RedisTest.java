package test.redis;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void RedisDB() {

		String host = "10.0.10.36";
//		String host = "119.23.190.31";
		int port = 6379;
		Jedis jedis = null;
		try {
			jedis = new Jedis(host, port);
			jedis.auth("ztessc_123");
//			jedis.auth("root");
			jedis.select(1);
			jedis.set("name", "张三");
			String name = jedis.get("name");
			System.out.println("name = " + name);
			jedis.flushDB();
			String name2 = jedis.get("name");
			System.out.println("name2 = " + name2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != jedis) {
				try {
					jedis.close();
				} catch (Exception e) {
					System.out.println("redis连接关闭失败");
					e.printStackTrace();
				}
			}
		}
	}
	public static void RedisNoPwd() {
		
		String host = "192.168.2.100";
		int port = 6380;
		Jedis jedis = null;
		try {
			jedis = new Jedis(host, port);
			jedis.set("name", "张三");
			String name = jedis.get("name");
			System.out.println("name = " + name);
			jedis.flushDB();
			String name2 = jedis.get("name");
			System.out.println("name2 = " + name2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != jedis) {
				try {
					jedis.close();
				} catch (Exception e) {
					System.out.println("redis连接关闭失败");
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		// // 连接本地的 Redis 服务
		// Jedis jedis = new Jedis("192.168.2.100", 6379);
		// jedis.auth("ztescc_123");
		// System.out.println("连接成功");
		// // 查看服务是否运行
		// System.out.println("服务正在运行: " + jedis.ping());
		RedisDB();
//		RedisNoPwd();
	}

}
