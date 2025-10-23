package com.example.videomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.videomanager.model.Video;

/**
 * Spring Data JPA repository for the {@link Video} entity.
 * <p>
 * This interface provides CRUD (Create, Read, Update, Delete) operations for videos.
 * </p>
 */
@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}