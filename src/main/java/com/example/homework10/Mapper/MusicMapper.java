package com.example.homework10.Mapper;

import com.example.homework10.Entity.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper

public interface MusicMapper {
    @Select("select * from music")
    List<Music> findAll();
    
}
