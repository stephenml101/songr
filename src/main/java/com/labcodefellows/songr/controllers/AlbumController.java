package com.labcodefellows.songr.controllers;


import com.labcodefellows.songr.models.Album;
import com.labcodefellows.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model model) {
        List<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);

        return "albums";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title,
                                 String artist,
                                 String imageUrl) {
        Album newAlbum = new Album(title, artist, imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

    @DeleteMapping("/delete-album/")
    public RedirectView deleteAlbum(long albumId) {
        System.out.println(albumId);
        albumRepository.deleteById(albumId);
        return new RedirectView("/albums");
    }

    @GetMapping("/album-detail/{id}")
    public String albumDetailView(@PathVariable long id, Model m) {
        Album album = albumRepository.getById(id);
        m.addAttribute("album", album);
        return "album-detail.html";
    }
}
