package com.example.homework10.Mapper;

import com.example.homework10.Entity.Music;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface MusicMapper {
    @Select("select * from music")
    List<Music> findAll();

    @Select("select * from music where id = #{id}")
    Music findById(int id);

    @Insert("Insert INTO music (title, singer) values (#{title}, #{singer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createMusic(Music createMusic);

    @Update("Update music set title = #{title}, singer = #{singer} where id = #{id}")
    void updateMusic(Music updateMusic);

    @Delete("Delete from music where id = #{id}")
    void deleteMusic(int id);
}
