package com.example.homework10.service;

import com.example.homework10.entity.Music;
import com.example.homework10.exception.NotMusicFoundException;
import com.example.homework10.mapper.MusicMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

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

    @Test
    public void 存在するIDのミュージックが返されること() throws Exception {
        Music music = new Music(5, "ハルカ", "YOASOBI");
        doReturn(music).when(musicMapper).findById(5);

        Music actual = musicService.findById(5);
        assertThat(actual).isEqualTo(music);
        verify(musicMapper, times(1)).findById(5);
    }

    @Test
    public void 存在しないIDのミュージックを取得しようとすると例外が発生すること() throws Exception {
        doThrow(new NotMusicFoundException("Music not found")).when(musicMapper).findById(5);

        assertThatThrownBy(() -> musicService.findById(5)).isInstanceOfSatisfying(NotMusicFoundException.class, e -> assertThat(e.getMessage()).isEqualTo("Music not found"));
        verify(musicMapper, times(1)).findById(5);
    }

    @Test
    public void ミュージックが作成されること() {
        Music music = new Music("明日への扉", "kiroro");
        doNothing().when(musicMapper).createMusic(music);

        musicService.createMusic(music.getTitle(), music.getSinger());
        verify(musicMapper, times(1)).createMusic(music);
    }

    @Test
    public void 存在するミュージックが更新されること() throws Exception {
        Music music = new Music(5, "ハルカ", "YOASOBI");
        doNothing().when(musicMapper).updateMusic(music.getId(), music.getTitle(), music.getSinger());

        musicService.updateMusic(5, "ハルカ", "YOASOBI");
        verify(musicMapper, times(1)).updateMusic(music.getId(), music.getTitle(), music.getSinger());
    }

    @Test
    public void 存在しないミュージックが更新されようとすると例外が発生すること() throws Exception {
        doReturn(Optional.empty()).when(musicMapper).findById(5);

        assertThatThrownBy(() -> musicService.updateMusic(5, "ハルカ", "YOASOBI")).isInstanceOfSatisfying(NotMusicFoundException.class, e -> assertThat(e.getMessage()).isEqualTo("Music not found"));
        verify(musicMapper, times(1)).findById(5);
    }

    @Test
    public void 存在するミュージックが削除されること() throws Exception {
        doNothing().when(musicMapper).deleteMusic(5);

        musicService.deleteMusic(5);
        verify(musicMapper, times(1)).deleteMusic(5);
    }
}
