package com.webage.api;

import org.junit.Test; 
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ServiceAPI.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ServiceAPITest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() { 
        System.out.println("in contextLoads() test.");
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        System.out.println("in shouldReturnDefaultMessage() test.");
        this.mockMvc.perform(get("/"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("up and running!")))
                    .andDo(document("service-api"));
    }

}
