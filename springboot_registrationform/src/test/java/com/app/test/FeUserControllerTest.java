package com.app.test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.app.entity.FeUser;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class FeUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRegisterUser() throws Exception {
        FeUser newUser = new FeUser();
      //  newUser.setFeUserId("testUserId");
        newUser.setFirstName("John");
        newUser.setLastName("Doe");
        newUser.setEmail("johndoe@example.com");
        newUser.setPassword("mysecretpassword");
        newUser.setPhone("123-456-7890");
        newUser.setCell("987-654-3210");
        newUser.setDefaultSchoolId(1);
        newUser.setWid("wid123");
        newUser.setTextable(1);

        mockMvc.perform(post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feUserId").value("testUserId"))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.email").value("johndoe@example.com"))
                .andExpect(jsonPath("$.password").value("mysecretpassword"))
                .andExpect(jsonPath("$.phone").value("123-456-7890"))
                .andExpect(jsonPath("$.cell").value("987-654-3210"))
                .andExpect(jsonPath("$.defaultSchoolId").value(1))
                .andExpect(jsonPath("$.wid").value("wid123"))
                .andExpect(jsonPath("$.textable").value(1));
    }
}
