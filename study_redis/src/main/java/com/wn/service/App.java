package com.wn.service;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();


        System.out.println( "Hello World!" );
        //连接本地的 Redis 服务
        // Jedis jedis = new Jedis("localhost");

        Jedis jedis = RedisPool.getJedis();
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");

        jedis.set("cao", "caowenlong");

        jedis.set("user::zhang", app.setObjectProperty());

        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
    }

    private String setObjectProperty() {
        UserDTO userDTO = new UserDTO();
        Long id = new Long(123456);
        userDTO.setId(id);
        userDTO.setName("张三");
        Byte sex = new Byte(String.valueOf(0));
        userDTO.setSex(sex);
        userDTO.setAge(24);
        return userDTO.toString();
    }
}
