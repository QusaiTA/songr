package com.songr.songr.Controller;

import com.songr.songr.Model.Albums;
import com.songr.songr.Model.Song;
import com.songr.songr.repository.AlbumRepository;
import com.songr.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BasicController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;



    @GetMapping("/hello")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World")String name, Model model){
        model.addAttribute("name", name);
       return "Welcome";
    }

    @GetMapping("/capitalize/{name}")
    public String toUpperCase(@PathVariable String name, Model model){
       model.addAttribute("name",name.toUpperCase());
       return "toUpperCase";
    }

    @GetMapping("/getAllAlbums")
    public String albums(Model model){
        ArrayList<Albums>albums = new ArrayList<>();
        Albums first = new Albums("romantic album","JB" , 344,200,"https://media.newyorker.com/photos/5e2b598351d1330009001749/master/pass/Fry-JustinBieberDocuseries.jpg");
        Albums second = new Albums("rab album","Eminem" , 32,452,"https://etbilarabi.com/sites/default/files/styles/article_landing/public/2020-03/BAFBDC61-35D2-4A4E-A9F6-4C41F1B47403.jpeg?itok=zNDV0gxy");
        Albums third = new Albums("fun album","Selena Gomez" , 20,5000,"https://etbilarabi.com/sites/default/files/styles/article_landing/public/2020-03/BAFBDC61-35D2-4A4E-A9F6-4C41F1B47403.jpeg?itok=zNDV0gxy");
        albums.add(first);
        albums.add(second);
        albums.add(third);
        model.addAttribute("album",albums);
        return "StaticAlbums";
    }

    @PostMapping("/albums")
    public RedirectView createAlbum(@ModelAttribute Albums albums){
        albumRepository.save(albums);
        return new RedirectView("/albums");
    }

    @GetMapping("/albums")
    public String getAlbumsAllData(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "newAlbums";
    }

    @GetMapping("/songs")
    public String getSongs(Model song){
        List<Song>songs = songRepository.findAll();
        song.addAttribute("song",songs);
        return "songs";
    }

    @GetMapping("/addSong")
    public String Form(){
        return "addSong";
    }

    @PostMapping("/songs")
    public RedirectView addSong(@RequestParam (value = "albumID")Long albums_id,Model song,
                                @RequestParam (value = "title")String title,
                                @RequestParam (value = "length")int length,
                                @RequestParam (value = "trackNumber")int trackNumber){
        Albums albums = albumRepository.findById(albums_id).get();
        Song songs = new Song(albums,title,length,trackNumber);
        songRepository.save(songs);
        Albums albums1 = albumRepository.findById(albums.getId()).get();
        song.addAttribute("song", albums1.getSongs());

        return new RedirectView("/songs");
    }








}
