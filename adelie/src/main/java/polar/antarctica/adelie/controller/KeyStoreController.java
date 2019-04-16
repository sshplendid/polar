package polar.antarctica.adelie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polar.antarctica.adelie.model.RedisModel;

@Slf4j
@RestController
@RequestMapping("/keys")
public class KeyStoreController {

    private RedisTemplate<byte[], byte[]> redisTemplate;

    public KeyStoreController(RedisTemplate<byte[], byte[]> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/{key}")
    public String getValueByKey(@PathVariable String key) {
        ValueOperations<byte[], byte[]> ops = redisTemplate.opsForValue();

        byte[] value = ops.get(key.getBytes());
        log.info("K: {}, V: {}", key, value);

        return "OK";
    }

    @PostMapping("")
    public ResponseEntity<String> setValueByKey(RedisModel model) {
        log.info("POST /keys | {} ", model.toString());
        String key = model.getKey();
        byte[] value = model.getValue();
        log.info("POST /keys | {} {}", key, String.valueOf(value));

        ValueOperations<byte[], byte[]> ops = redisTemplate.opsForValue();

        ops.set(key.getBytes(), value);
        return new ResponseEntity<>("value is stored by key.", HttpStatus.OK);
    }
}
