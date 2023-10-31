package com.example.homework10.Service;

import com.example.homework10.Entity.Music;
import com.example.homework10.Mapper.MusicMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class MusicServiceImplTest {
    @InjectMocks
    MusicServiceImpl musicService;

    @Mock
    MusicMapper musicMapper;

    @Test
    public void 全てのミュージックが返される事() throws Exception {
        List<Music> musicList = List.of(
                new Music(5, "ハルカ", "YOASOBI"),
                new Music(6, "炎", "LiSA"),
                new Music(7, "紅蓮華", "LiSA")

        );
        doReturn(musicList).when(musicMapper).findAll();

        List<Music> actual = musicService.findAll();
        assertThat(actual).isEqualTo(musicList);
        verify(musicMapper, times(1)).findAll();
    }

}
