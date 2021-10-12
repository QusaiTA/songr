package com.songr.songr.repository;

import com.songr.songr.Model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Albums,Long> {
}
