package com.oyc.redis;

import com.oyc.bean.Student;
import redis.clients.jedis.Jedis;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SerializeUtil {
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            //序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
        }
        return null;
    }

    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            //反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        /*Jedis jedis = new Jedis();
        Student stu = new Student();
        stu.setId(168);
        stu.setName("redis");
        stu.setAge(18);
        stu.setSex("男");
        stu.setCls("188");
        stu.setAddress("China");
       // jedis.set("student".getBytes(), SerializeUtil.serialize(stu));

        byte[] student = jedis.get(("student").getBytes());
        System.out.println(SerializeUtil.unserialize(student));*/
        //f01919daf00b4a8331e9f380b5bc6e98
        //7eae565e82492e23eade76be7b7a537d
        //68a24d67cdf2dd5f91193ac628bc81af
        String s = "1234567890";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
           // System.out.println(new BigInteger(1, md.digest()).toString(16));


        } catch (NoSuchAlgorithmException e) {

        }

    }
}