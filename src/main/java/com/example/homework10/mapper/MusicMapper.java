package com.example.homework10.mapper;

import com.example.homework10.entity.Music;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface MusicMapper {
    @Select("SELECT * FROM music")
    List<Music> findAll();

    @Select("SELECT * FROM music WHERE id = #{id}")
    Music findById(int id);

    @Insert("Insert INTO music (title, singer) VALUES (#{title}, #{singer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createMusic(Music createMusic);

    @Update("Update music SET title = #{title}, singer = #{singer} WHERE id = #{id}")
    void updateMusic(Music updateMusic);

    @Delete("Delete FROM music WHERE id = #{id}")
    void deleteMusic(int id);

}
