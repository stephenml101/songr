package com.labcodefellows.songr.controllers;

import com.labcodefellows.songr.models.Album;
import com.labcodefellows.songr.models.Song;
import com.labcodefellows.songr.repository.AlbumRepository;
import com.labcodefellows.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

    @PostMapping("addSong")
    public RedirectView addSong(long albumId, String title, int length, int trackNumber) {
        Album album = albumRepository.getReferenceById(albumId);
        Song song = new Song(title, length, trackNumber);
        album.addSong(song);
        songRepository.save(song);
        album.calculateAlbumLength();
        albumRepository.save(album);
        return new RedirectView("/album-detail/" + albumId);
    }

    @GetMapping("songs")
    public String getSongsPage(Model m) {
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "songs.html";
    }
}
