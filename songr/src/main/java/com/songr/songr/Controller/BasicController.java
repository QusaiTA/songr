package com.songr.songr.Controller;

import com.songr.songr.Model.Albums;
import com.songr.songr.Model.Song;
import com.songr.songr.repository.AlbumRepository;
import com.songr.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Locale;

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

    Albums albums []= {
            new Albums("romantic album","JB" , "https://media.newyorker.com/photos/5e2b598351d1330009001749/master/pass/Fry-JustinBieberDocuseries.jpg",200,2000),
            new Albums("rab album","Eminem" , "https://etbilarabi.com/sites/default/files/styles/article_landing/public/2020-03/BAFBDC61-35D2-4A4E-A9F6-4C41F1B47403.jpeg?itok=zNDV0gxy",452,10000),
            new Albums("fun album","Selena Gomez" , "https://images.indianexpress.com/2021/08/Selena-Gomez-1200.jpg",5000,20),
    };


    @GetMapping("/albums")
    public String albums(Model model){
        model.addAttribute("album",albums);
        return "albums";
    }

    @GetMapping("/albums2")

    public String getAlbumsAllData(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "albums";
    }

    @PostMapping("/albums2")
    public RedirectView addNewAlbum(@RequestParam (value = "title") String title ,
                                    @RequestParam (value = "artist") String artist,
                                    @RequestParam (value = "imageURL") String imageURL ,
                                    @RequestParam (value = "songCount") int songCount,
                                    @RequestParam (value = "length")  int length)
    {

        Albums albums = new Albums(title,artist,imageURL,songCount,length);
        albumRepository.save(albums);
        return new RedirectView("/albums2");

    }

    @GetMapping("/songs")
    public String getSongs(Model song){
        song.addAttribute("song",songRepository.findAll());
        return "songs";
    }

    @GetMapping("/addSong")
    public String Form(){
        return "addSong";
    }

    @PostMapping("/songs")
    public RedirectView addSong(@RequestParam Long albums_id,
                                @RequestParam String title,
                                @RequestParam int length,
                                @RequestParam int trackNumber){
        Albums albums = albumRepository.getById(albums_id);
        Song song = new Song(albums,title,length,trackNumber);
        songRepository.save(song);

        return new RedirectView("/songs");
    }







}
