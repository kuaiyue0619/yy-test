package my.ky.test.web.controller;

import lombok.extern.slf4j.Slf4j;
import my.ky.test.commons.enums.ErrorCode;
import my.ky.test.commons.exception.BusiException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>测试控制器</li>
 * <li>User:ky Date:2017/12/29 Time:18:05</li>
 * </ul>
 */
@Slf4j
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        log.debug("Logger Level ：DEBUG");
        log.info("Logger Level ：INFO");
        log.error("Logger Level ：ERROR");
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        // 加入一个属性，用来在模板中读取
        modelMap.addAttribute("text", "启动成功！！");
        modelMap.addAttribute("user", "杨大仙");
        modelMap.addAttribute("data", map);
        // return模板文件的名称，对应src/main/resources/templates/index.ftl
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/hello/{myName}")
    @ResponseBody
    public String index(@PathVariable String myName) {
        return "Hello " + myName + "!!!";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/exception")
    public String exception() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/busiException")
    public String busiException() {
        throw new BusiException(ErrorCode.SYS_BUSY);
    }
}
