package com.songr.songr.repository;

import com.songr.songr.Model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Albums,Long> {
}
