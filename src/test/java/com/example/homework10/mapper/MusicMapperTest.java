package com.example.homework10.mapper;

import com.example.homework10.entity.Music;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(
        scripts = {"classpath:/sqlannotation/delete-music.sql", "classpath:/sqlannotation/insert-music.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public class MusicMapperTest {
    @Autowired
    MusicMapper musicMapper;

    @Test
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

    @Test
    @Transactional
    void 指定したIDのミュージックが指定できる事() {
        Optional<Music> music = musicMapper.findById(5);
        assertThat(music)
                .isEqualTo(
                        new Music(5, "ハルカ", "YOASOBI")
                );
    }

    @Test
    @Transactional
    void 指定したIDがない場合に例外を返す事() {
        int id = 100;
        Optional<Music> music = musicMapper.findById(id);
        assertThat(music).isNull();
    }

    @Test
    @Transactional
    void ミュージックが作成される事() {
        Music music = new Music(8, "彗星の魔女", "YOASOBI");
        musicMapper.createMusic(music);
        Optional<Music> actual = musicMapper.findById(music.getId());
        assertThat(actual).isPresent();
        assertThat(actual.get()).isEqualTo(music);
        assertThat(actual.get().getTitle()).isEqualTo(music.getTitle());
        assertThat(actual.get().getSinger()).isEqualTo(music.getSinger());
        assertThat(actual.get().getId()).isEqualTo(music.getId());
    }

    @Test
    @Transactional
    void 更新したミュージックが反映されること() {
        Optional<Music> music = musicMapper.findById(5);
        assertThat(music).isEqualTo(Optional.of(new Music(5, "ハルカ", "YOASOBI")));
        musicMapper.updateMusic(5, "ハルカ", "YOASOBI");
    }

    @Test
    @Transactional
    void 指定したIDのミュージックが削除されること() {
        Optional<Music> music = musicMapper.findById(5);
        assertThat(music).isEqualTo(Optional.of(new Music(5, "ハルカ", "YOASOBI")));
        musicMapper.deleteMusic(5);
        Optional<Music> actual = musicMapper.findById(5);
        assertThat(actual).isEmpty();
    }
}
