package com.labcodefellows.songr.repository;

import com.labcodefellows.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    public Album findByName(String name);
}
