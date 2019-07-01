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


}
