package com.example.homework10.Mapper;

import com.example.homework10.Entity.Music;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MusicMapperTest {
    @Autowired
    MusicMapper musicMapper;

    @Test
    @Sql(
            scripts = {"classpath:/sqlannotation/delete-music.sql", "classpath:/sqlannotation/insert-music.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Transactional
    void 全てのミュージックが返される事() {
        List<Music> music = musicMapper.findAll();
        assertThat(music)
                .hasSize(3)
                .contains(
                        new Music(5, "ハルカ", "YOASOBI"),
                        new Music(6, "炎", "LiSA"),
                        new Music(7, "ドライフラワー", "優里")
                );
    }
}
