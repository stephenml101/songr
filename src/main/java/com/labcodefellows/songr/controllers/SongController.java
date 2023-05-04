package com.labcodefellows.songr.controllers;

import com.labcodefellows.songr.models.Album;
import com.labcodefellows.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    AlbumRepository albumRepository;

//    @PostMapping ("/song/add")
//    public RedirectView addSong(){
//        Album album;
//
//    }
}
