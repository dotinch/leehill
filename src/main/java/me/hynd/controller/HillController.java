package me.hynd.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import me.hynd.model.Hill;
import me.hynd.model.User;
import me.hynd.service.HillService;
import me.hynd.service.UserService;
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
@Api(value="Hill", description = "山丘管理")
@Controller
@RequestMapping("/v1/hill")
public class HillController {

    @Resource
    private HillService hillService;

    @ApiOperation(value="添加山丘", notes="李宗盛")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    int addUser(@RequestParam("id") String id,
                @ApiParam(name = "name", value = "山丘名字", required = true) @RequestParam("name") String name,
                HttpServletRequest request) {
        Hill hill = new Hill();
        hill.setId(id);
        hill.setName(name);
        this.hillService.insert(hill);
        return 99;
    }

    @ApiOperation("全部山丘")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody
    List<Hill> findAll() {
        return this.hillService.findAll();
    }

}
