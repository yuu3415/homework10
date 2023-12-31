package com.example.homework10.mapper;

import com.example.homework10.entity.Music;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper

public interface MusicMapper {
    @Select("SELECT * FROM music")
    List<Music> findAll();

    @Select("SELECT * FROM music WHERE id = #{id}")
    Optional<Music> findById(int id);

    @Select("SELECT * FROM music WHERE title = #{title}")
    Music findByTitle(String title);

    @Insert("INSERT INTO music (title, singer) VALUES (#{title}, #{singer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createMusic(Music createMusic);

    @Update("UPDATE music SET title = #{title}, singer = #{singer} WHERE id = #{id}")
    void updateMusic(int id, String title, String singer);

    @Delete("DELETE FROM music WHERE id = #{id}")
    void deleteMusic(int id);

}
