//package per.jxy.idempotentdemo.util;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//
//
//@Slf4j
//@Component
//public class JedisUtil {
//
//    @Autowired
//    private JedisPool jedisPool;
//
//    private Jedis getJedis(){
//        return jedisPool.getResource();
//    }
//
//    /**
//     * 设值
//     */
//    private String set(String key,String value){
//        Jedis jedis = null;
//        try {
//            jedis = getJedis();
//            return jedis.set(key, value);
//        }catch (Exception e){
//            System.out.println("设置key="+key+":value="+value+"值异常");
//            return null;
//        }finally {
//            close(jedis);
//        }
//    }
//
//    /**
//     * 设值  并且设置过期时间
//     */
//    private String set(String key,String value,int expireTime){
//        Jedis jedis = null;
//        try {
//            jedis = getJedis();
//            return jedis.setex(key,expireTime,value);
//        }catch (Exception e){
//            System.out.println("设置key="+key+":value="+value+":expireTime="+expireTime+"异常");
//            return null;
//        }finally {
//            close(jedis);
//        }
//    }
//    /**
//     * 取值
//     */
//    private String get(String key){
//        Jedis jedis = null;
//        try {
//            jedis = getJedis();
//            return jedis.get(key);
//        }catch (Exception e){
//            System.out.println("获取redis中，key="+key+"的值异常!");
//            return null;
//        }finally {
//            close(jedis);
//        }
//    }
//
//
//    /**
//     * 判断key是否存在
//     */
//    private boolean exist(String key){
//        Jedis jedis = null;
//        try {
//            jedis = getJedis();
//            return jedis.exists(key);
//        }catch (Exception e){
//            System.out.println("判断key="+key+"是否存在异常");
//            return false;
//        }finally {
//            close(jedis);
//        }
//    }
//
//    /**
//     * 删除key
//     */
//    private Long del(String key){
//        Jedis jedis = null;
//        try {
//            jedis = getJedis();
//            return jedis.del(key);
//        }catch (Exception e){
//            System.out.println("删除key="+key+"是否发生异常");
//            return null;
//        }finally {
//            close(jedis);
//        }
//    }
//
//
//    /**
//     * 获取剩余时间
//     */
//    private Long ttl(String key){
//        Jedis jedis = null;
//        try {
//            jedis = getJedis();
//            return jedis.ttl(key);
//        }catch (Exception e){
//            System.out.println("获取key="+key+"的剩余时间发生异常");
//            return null;
//        }finally {
//            close(jedis);
//        }
//    }
//
//    /**
//     * 设置key的过期时间
//     */
//    private Long  expire(String key,int expireTime){
//        Jedis jedis = null;
//        try {
//            jedis = getJedis();
//            return jedis.expire(key,expireTime);
//        }catch (Exception e){
//            System.out.println("设置key="+key+"的过期时间发生异常");
//            return null;
//        }finally {
//            close(jedis);
//        }
//    }
//
//
//
//    /**
//     * 关闭Jedis
//     * @param jedis
//     */
//    private void close(Jedis jedis){
//        if (jedis != null){
//            jedis.close();
//        }
//    }
//
//}
