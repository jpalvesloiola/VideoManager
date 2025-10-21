package com.example.videomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.videomanager.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}