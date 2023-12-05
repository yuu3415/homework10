package com.example.homework10.integrationtest;


import com.example.homework10.entity.Music;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MusicApiIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Transactional
    @DataSet("datasets/music.yml")
    void ミュージックが全て取得できること() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.get("/music"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        JSONAssert.assertEquals("""
                [
                    {
                        "id":1,
                        "title":"The Beginning",
                        "singer":"ONE OK ROCK
                    },
                    {
                        "id":2,
                        "title":"Pretender",
                        "singer":"Official髭男dism"
                    },
                    {
                        "id":3,
                        "title":"Lemon",
                        "singer":"米津玄師"
                    }
                ]
                """, response, JSONCompareMode.STRICT);
    }

    @Test
    @DataSet(value = "datasets/music.yml")
    @Transactional
    void 指定したIDのミュージックが取得できること() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.get("/music/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        JSONAssert.assertEquals("""
                {
                    "id":1,
                    "title":"The Beginning",
                    "singer":"ONE OK ROCK
                }
                """, response, JSONCompareMode.STRICT);
    }

    @Test
    @DataSet(value = "datasets/music.yml")
    @Transactional
    void 指定したIDが存在しない場合に404が返ること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/music/100"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn().getResponse().getErrorMessage();
    }

    @Test
    @DataSet(value = "datasets/music.yml")
    @ExpectedDataSet(value = "datasets/expected_music.yml", ignoreCols = "id")
    @Transactional
    void ミュージックが作成されること() throws Exception {
        Music music = new Music(39, "ハルカ", "YOASOBI");
        String response =
                mockMvc.perform(MockMvcRequestBuilders.post("/music")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {
                                            "title": "ハルカ",
                                            "singer": "YOASOBI"
                                        }
                                        """))
                        .andExpect(MockMvcResultMatchers.status().isCreated())
                        .andExpect(header().string("Location", matchesPattern("http://localhost:8080/music/\\d+"))).toString();

    }

    @Test
    @DataSet(value = "datasets/music.yml")
    @Transactional
    void ミュージックが更新されること() throws Exception {
        String response =
                mockMvc.perform(MockMvcRequestBuilders.patch("/music/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {
                                            "title": "アイドル",
                                            "singer": "YOASOBI"
                                        }
                                        """))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        JSONAssert.assertEquals("""
                {
                    "message": "music successfully updated"
                }                   
                """, response, JSONCompareMode.STRICT);
    }

    @Test
    @DataSet(value = "datasets/music.yml")
    @Transactional
    void 存在しないIDのミュージックを更新しようとすると404が返ること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/music/100")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "title": "アイドル",
                                    "singer": "YOASOBI"
                                }
                                """))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn().getResponse().getErrorMessage();
    }

    @Test
    @DataSet(value = "datasets/music.yml")
    @Transactional
    void ミュージックが削除されること() throws Exception {
        String response =
                mockMvc.perform(MockMvcRequestBuilders.delete("/music/1"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        JSONAssert.assertEquals("""
                {
                    "message": "music successfully deleted"
                }
                """, response, JSONCompareMode.STRICT);
    }

}
