package com.psychology.api.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.ManageDTO;
import com.psychology.api.dto.TeachersDTO;
import com.psychology.api.service.ManageService;
import com.psychology.api.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 后台管理登录控制器
 * @author: wuming
 * @Create: 2023.04.15 16:26:32
 */
@RestController
@RequestMapping("/manage/login")
public class LoginController {

    static Map<String, String> userInfoMap = new HashMap<>();

    @Autowired
    private ManageService manageService;

    @Autowired
    private TeachersService teachersService;

    @PostMapping
    public ReturnMsg manageLogin(@RequestBody Map<String, String> param) {
        if (StrUtil.isEmpty(param.get("username")) || StrUtil.isEmpty(param.get("password"))) {
            return ReturnMsg.error("用户名或密码错误!");
        }
        ManageDTO manageDTO = new ManageDTO();
        manageDTO.setUserName(param.get("username"));
        manageDTO.setPassWord(param.get("password"));
        QueryWrapper<ManageDTO> manageDTOQueryWrapper = new QueryWrapper<>(manageDTO);
        manageDTOQueryWrapper.last("limit 1");
        ManageDTO adminDTOS = manageService.getOne(manageDTOQueryWrapper);
        if (adminDTOS == null) return ReturnMsg.error("用户名或密码错误!");
        Map<String, Object> map = new HashMap<>();
        map.put("avatar", StrUtil.isNotBlank(adminDTOS.getPhotoImg()) ? adminDTOS.getPhotoImg() : "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("introduction", adminDTOS.getName() + ",你好!");
        map.put("name", adminDTOS.getName());
        map.put("roles", Arrays.asList("admin"));
        Map<String, String> returnMap = new HashMap<>();
        String uuid = UUID.randomUUID().toString();
        returnMap.put("token", uuid);
        userInfoMap.put(uuid, JSON.toJSONString(map));
        return ReturnMsg.ok(returnMap);
    }

    @PostMapping("/tea")
    public ReturnMsg teacherLogin(@RequestBody Map<String, String> param) {
        if (StrUtil.isEmpty(param.get("username")) || StrUtil.isEmpty(param.get("password"))) {
            return ReturnMsg.error("用户名或密码错误!");
        }
        TeachersDTO manageDTO = new TeachersDTO();
        manageDTO.setUsername(param.get("username"));
        manageDTO.setPassword(param.get("password"));
        QueryWrapper<TeachersDTO> manageDTOQueryWrapper = new QueryWrapper<>(manageDTO);
        manageDTOQueryWrapper.last("limit 1");
        TeachersDTO adminDTOS = teachersService.getOne(manageDTOQueryWrapper);
        if (adminDTOS == null) return ReturnMsg.error("用户名或密码错误!");
        Map<String, Object> map = new HashMap<>();
        map.put("avatar", StrUtil.isNotBlank(adminDTOS.getTeaImg()) ? adminDTOS.getTeaImg() : "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("introduction", adminDTOS.getTeaName() + ",你好!");
        map.put("name", adminDTOS.getTeaName());
        map.put("id", adminDTOS.getId());
        map.put("roles", Arrays.asList("admin"));
        Map<String, String> returnMap = new HashMap<>();
        String uuid = UUID.randomUUID().toString();
        returnMap.put("token", uuid);
        userInfoMap.put(uuid, JSON.toJSONString(map));
        return ReturnMsg.ok(returnMap);
    }

    @GetMapping
    public ReturnMsg getUserInfo(@RequestParam("token") String token) {
        if (!userInfoMap.containsKey(token)) return ReturnMsg.error("尚未登录,请重新登录!");
        return ReturnMsg.ok(JSON.parse(userInfoMap.get(token)));
    }

    @GetMapping("/logout")
    public ReturnMsg logout(@RequestParam("token") String token) {
        userInfoMap.remove(token);
        return ReturnMsg.ok();
    }

}
