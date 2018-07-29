package com.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//https://www.programcreek.com/java-api-examples/index.php?api=org.springframework.test.web.servlet.request.MockMvcRequestBuilders
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
        String jsonContent = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("payload/userEntity.json"));

        String jsonResponse = this.mockMvc.perform(
                post(PATH + "user")
                        .contentType(APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id", Matchers.notNullValue()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString();


        ObjectMapper mapper = new ObjectMapper();
        UserIdResponse userID = mapper.readValue(jsonResponse, UserIdResponse.class);

        UserEntity user = repository.findOne(userID.getId());

        Assertions.assertThat(user.getName()).isEqualTo("Eduardo");
        Assertions.assertThat(user.getPassword()).isEqualTo("123");

    }

    @Test
    public void createV2() throws Exception {

        Map<String, String> data = new HashMap<>();
        data.put("name","Delfino");
        data.put("password", "12");

        String jsonResponse = this.mockMvc.perform(
                post(PATH + "user")
                        .contentType(APPLICATION_JSON)
                        .content(JSONObject.toJSONString(data)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id",  Matchers.notNullValue()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString();


        ObjectMapper mapper = new ObjectMapper();
        UserIdResponse userID = mapper.readValue(jsonResponse, UserIdResponse.class);

        UserEntity user = repository.findOne(userID.getId());

        Assertions.assertThat(user.getName()).isEqualTo("Delfino");
        Assertions.assertThat(user.getPassword()).isEqualTo("12");

    }

    @Test
    public void updateV2() throws Exception {
        UserEntity edit = save();
        int id = Integer.parseInt(valueOf(edit.getId()));

        Map<String, String> data = new HashMap<>();
        data.put("id", valueOf(id));
        data.put("name","Ludimila Martins");
        data.put("password", "1");

        String jsonResponse = this.mockMvc.perform(
                put(PATH + "edit")

                        .contentType(APPLICATION_JSON)
                        .content(JSONObject.toJSONString(data)))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("id", Matchers.is(id)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString();


        ObjectMapper mapper = new ObjectMapper();
        UserIdResponse userID = mapper.readValue(jsonResponse, UserIdResponse.class);

        UserEntity user = repository.findOne(userID.getId());

        Assertions.assertThat(user.getId()).isEqualTo(id);
    }


    @Test
    public void delete() throws Exception {

        UserEntity created = save();
        String id = valueOf(created.getId());

        this.mockMvc.perform(
                MockMvcRequestBuilders.delete(PATH + id)
                        .param("id",id)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Assertions.assertThat(id).isNotNull();
    }

    @Test
    public void deleteNotFound() throws Exception {


        this.mockMvc.perform(
                MockMvcRequestBuilders.delete(PATH )
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }


    @Test
    public void NotFound() throws Exception {
        String jsonContent = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("payload/userEntityNotfound.json"));
        this.mockMvc.perform(
                post(PATH + "user")
                        .contentType(APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());

    }

    private UserEntity save(){
        UserEntity created = new UserEntity("Ludimila Alves","123");
        UserEntity user = repository.save(created);
        return user;
    }

}