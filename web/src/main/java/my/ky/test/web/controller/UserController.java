package my.ky.test.web.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import my.ky.test.dal.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>用户控制器</li>
 * <li>User:ky Date:2018/1/2 Time:16:38</li>
 * </ul>
 */
@RestController
public class UserController {

    // 创建线程安全的Map
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "查询用户列表", notes = "")
    @RequestMapping(value = "/user/queryList", method = RequestMethod.GET)
    public List<User> queryUsers() {
        return new ArrayList<User>(users.values());
    }

    @ApiOperation(value = "新增用户", notes = "")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "根据ID查询用户", notes = "")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/user/getById", method = RequestMethod.GET)
    public User getUser(Long id) {
        return users.get(id);
    }

    @ApiOperation(value = "更新用户", notes = "根据ID来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String putUser(@RequestBody User user) {
        User u = users.get(user.getId());
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(user.getId(), u);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据ID来删除用户")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public String deleteUser(Long id) {
        users.remove(id);
        return "success";
    }
}
