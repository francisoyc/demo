package com.oyc.redis;

import com.oyc.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisAutoTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void save() {
        stringRedisTemplate.opsForValue().set("foo2", "hello world");
    }

    @Test
    public void get() {
        String s = stringRedisTemplate.opsForValue().get("foo");
        String s1 = stringRedisTemplate.opsForValue().get("foo2");
        System.out.println("-------------------" + s + "====" + s1);
    }

    @Test
    public void testObj() throws Exception {
        //Student stu = new Student("test", 36, "男");
        Student stu = new Student();
        stu.setId(168);
        stu.setName("redis");
        stu.setAge(18);
        stu.setSex("男");
        stu.setCls("188");
        stu.setAddress("China");
        ValueOperations<String, Student> operations = redisTemplate.opsForValue();
        operations.set("redis", stu);
       // operations.set("com.neo.f", stu,1,TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("redis");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }

        redisTemplate.delete("redis");
        Student s = operations.get("redis");
        System.out.println(s);
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }

}