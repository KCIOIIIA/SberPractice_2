package com.example.repository;

import com.example.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
}
