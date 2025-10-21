package com.example.videomanager.service;

import com.example.videomanager.model.Video;
import com.example.videomanager.repository.VideoRepository;
import com.example.videomanager.dto.VideoDto;
import com.example.videomanager.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    private VideoDto toDto(Video v) {
        return new VideoDto(v.getId(), v.getTitle(), v.getDescription(), v.getUrl());
    }

    private Video toEntity(VideoDto dto) {
        return new Video(dto.getId(), dto.getTitle(), dto.getDescription(), dto.getUrl(), null);
    }

    public List<VideoDto> getAllVideos() {
        return videoRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public VideoDto getVideoById(Long id) {
        Video v = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Video not found with id " + id));
        return toDto(v);
    }

    public VideoDto createVideo(VideoDto videoDto) {
        Video video = toEntity(videoDto);
        Video saved = videoRepository.save(video);
        return toDto(saved);
    }

    public VideoDto updateVideo(Long id, VideoDto videoDto) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Video not found with id " + id));
        video.setTitle(videoDto.getTitle());
        video.setDescription(videoDto.getDescription());
        video.setUrl(videoDto.getUrl());
        Video saved = videoRepository.save(video);
        return toDto(saved);
    }

    public void deleteVideo(Long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Video not found with id " + id));
        videoRepository.delete(video);
    }
}