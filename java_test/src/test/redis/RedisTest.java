package test.redis;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
		 //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("203.175.149.182",6379);
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
	}

}
