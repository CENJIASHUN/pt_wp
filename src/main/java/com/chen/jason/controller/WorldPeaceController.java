package com.chen.jason.controller;

import com.chen.jason.model.WorldPeace;
import com.chen.jason.service.WorldPeaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/3/30. By CenJS
 */
@Api(tags = "世界和平")
@RestController
public class WorldPeaceController {

    @Autowired
    private WorldPeaceService worldPeaceService;

    @ApiOperation(value = "HelloWorld!")
    @GetMapping("/helloWP")
    public String helloWP() throws Exception {
        return "Hello World & P";
    }

    @ApiOperation(value = "tk.mabaits批量插入")
    @GetMapping("/insertList")
    public List<WorldPeace> insertList(){
        List<WorldPeace> list = new ArrayList<>();
        WorldPeace worldPeace = new WorldPeace();
        worldPeace.setId(1);
        worldPeace.setName("1");
        worldPeace.setIsDelete(1);
        WorldPeace worldPeace2 = new WorldPeace();
        worldPeace2.setId(2);
        worldPeace2.setName("2");
        worldPeace2.setIsDelete(2);
        WorldPeace worldPeace3 = new WorldPeace();
        worldPeace3.setId(3);
        worldPeace3.setName("3");
        worldPeace3.setIsDelete(3);
        list.add(worldPeace);
        list.add(worldPeace2);
        list.add(worldPeace3);
        return worldPeaceService.insertList(list);
    }

}
