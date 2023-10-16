package com.example.homework10.Mapper;

import com.example.homework10.Entity.Music;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper

public interface MusicMapper {
    @Select("select * from music")
    List<Music> findAll();

    @Insert("Insert INTO music (title, singer) values (#{title}, #{singer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createMusic(Music createMusic);
}
