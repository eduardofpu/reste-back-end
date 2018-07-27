package com.user;

import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends AbstractTest {

    private final String PATH = "/";

    @Test
    public void findAll() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(PATH + "users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void create() throws Exception {
        String jsonContent = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("userEntity.json"));
        this.mockMvc.perform(
                post(PATH + "user")
                        .contentType(APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void createNotFound() throws Exception {
        String jsonContent = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("userEntityNotfound.json"));
        this.mockMvc.perform(
                post(PATH + "user")
                        .contentType(APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }

    /*@Test
    public void update() throws Exception {
        String jsonContent = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("userEntityUpdate.json"));
        this.mockMvc.perform(
                put(PATH + "edit")
                        .contentType(APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", Matchers.is(1)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void delete() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete(PATH + 1L)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }*/

}