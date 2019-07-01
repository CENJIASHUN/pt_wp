package com.chen.jason;

import com.chen.jason.controller.WorldPeaceController;
import com.chen.jason.model.WorldPeace;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasonApplicationTests {

    @Autowired
    WorldPeace worldPeace;

    private MockMvc mvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testWPvalue(){
        Assert.assertEquals(worldPeace.getId().toString(),"17");
        Assert.assertEquals(worldPeace.getName(),"CCCCCCCCCCCCCCCCCCCen");
    }

}
