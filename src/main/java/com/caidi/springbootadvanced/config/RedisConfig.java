package com.caidi.springbootadvanced.config;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * Redis相关配置
 *
 * @author caidi
 * @date 2018/09/27
 */
@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public RedisSerializer fastJsonJsonRedisSerializer() {
        return new FastJsonRedisSerializer(Object.class);
    }

    @Bean(value = "redisTemplate")
    @Primary
    public RedisTemplate<Object, Object> template(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(Object.class));
        redisTemplate.setHashValueSerializer(new FastJsonRedisSerializer<>(Object.class));
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean(value = "stringRedisTemplates")
    @Primary
    public RedisTemplate<Object, Object> stringTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(stringSerializer );
        redisTemplate.setValueSerializer(stringSerializer );
        redisTemplate.setHashKeySerializer(stringSerializer );
        redisTemplate.setHashValueSerializer(stringSerializer );
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


//	@Bean
//	public RedisCacheManager cacheManager(RedisTemplate redisTemplate) {
//		return new RedisCacheManager(redisTemplate);
//	}

}
