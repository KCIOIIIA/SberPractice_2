package com.example.repository;

import com.example.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
