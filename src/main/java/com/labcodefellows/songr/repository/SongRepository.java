package com.labcodefellows.songr.repository;

import com.labcodefellows.songr.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SongRepository extends JpaRepository<Song, Long> {
}