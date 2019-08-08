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
@WebMvcTest(CustomerAPI.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class CustomerAPITest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() { 
        System.out.println("in CustomerAPITest.contextLoads() test.");
    }

    @Test
    public void shouldReturnDefaultCustomers() throws Exception {
        System.out.println("in CustomerAPITest.shouldReturnDefaultCustomers() test.");
        String tokencheck = "false";
        this.mockMvc.perform(get("/customers?tokencheck=false").param("tokencheck",tokencheck))
                    .andExpect(!status().isOk());

/*                     .andExpect(content().string(containsString("Bruce")))
                    .andExpect(content().string(containsString("Paul")))
                    .andExpect(content().string(containsString("Rick")))
                    .andDo(document("customer-api")); */
    }

}
