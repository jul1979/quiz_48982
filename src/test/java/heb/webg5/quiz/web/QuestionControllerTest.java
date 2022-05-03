package heb.webg5.quiz.web;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionControllerTest {

   @Autowired
   private MockMvc mockMvc;

   @Test
   public void testDetailPage() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.get("/questions/1"))
              .andExpect(MockMvcResultMatchers.status().isOk())
              .andExpect(MockMvcResultMatchers.view().name("detail"))
              .andExpect(MockMvcResultMatchers.content().string(Matchers.stringContainsInOrder("Danube","2020-08-11")));
   }


}