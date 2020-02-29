package com.codull.sochat.controller;

import com.alibaba.fastjson.JSONObject;
import com.codull.sochat.constant.CommonConstant;
import com.codull.sochat.exception.GlobalException;
import com.codull.sochat.model.User;
import com.codull.sochat.service.ChatSessionService;
import com.codull.sochat.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @program: sochat
 * @description:
 * @author: anthony1314
 * @create: 2020-02-26 00:37
 **/
@Slf4j
@Controller
public class RouterController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ChatSessionService chatSessionService;

    /**
     * 登陆页面
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "login";
    }

    /**
     * 登录接口
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestBody User user) {
        Set<String> keys = redisTemplate.keys(CommonConstant.USER_PREFIX + CommonConstant.REDIS_MATCH_PREFIX);
        if (keys != null && keys.size() > 0) {
            keys.forEach(key -> {
                User entity = chatSessionService.findById(key);
                System.out.println(entity.getId()+entity.getName());
                if (entity != null) {
                    if ((entity.getName()).equals(user.getName())) {
                        throw new GlobalException("用户名已存在");
                    }
                }
            });
        }
        redisTemplate.boundValueOps(CommonConstant.USER_PREFIX + user.getId()).set(JSONObject.toJSONString(user));
        R s = new R();
        System.out.println(s.getCode());
        return s;
    }

    /**
     * 首页入口
     *
     * @return
     */
    @GetMapping("/{id}/chat")
    public String index(@PathVariable("id") String id) {
        User user = chatSessionService.findById(id);
        if (user == null) {
            return "redirect:/";
        }
        return "index";
    }
}
