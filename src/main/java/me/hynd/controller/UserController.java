package me.hynd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import me.hynd.model.User;
import me.hynd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by H on 2015/4/25.
 */
@Api(value="User", description = "用户管理")
@Controller
@RequestMapping("/v1/user")
public class UserController {

    static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    // @ApiParam(name = "id", value = "用户ID", required = true)
    @ApiOperation(value="添加用户", notes="Magic")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    int addUser(@RequestParam("id") String id,
                   @ApiParam(name = "name", value = "用户名字", required = true) @RequestParam("name") String name,
                   HttpServletRequest request) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return this.userService.insert(user);
    }

    @ApiOperation("全部用户")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody List<User> findAll() {
        PageHelper.startPage(1, 10);
        List<User> users = this.userService.findAll();
        PageInfo page = new PageInfo(users);
        logger.info("总数：{}", page.getTotal());

        return users;
    }

}
