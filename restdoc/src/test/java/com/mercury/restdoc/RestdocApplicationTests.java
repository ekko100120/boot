package com.mercury.restdoc;

import com.mercury.controller.RestedController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest(RestedController.class)
//@AutoConfigureRestDocs(outputDir = "target/snippets")
//@SpringBootTest
//public class RestdocApplicationTests {
//
//   @Autowired
//   private MockMvc mockMvc;
//	@Test
//	public void contextLoads() throws Exception {
//	   this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//		   .andExpect((ResultMatcher) content().string(containsString("rest api")))
//		   .andDo((document("index")));
//	}
//
//
//
//}
