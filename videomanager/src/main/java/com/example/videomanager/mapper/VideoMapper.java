package com.example.videomanager.mapper;

import com.example.videomanager.model.Video;
import com.example.videomanager.dto.VideoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VideoMapper {

    VideoDto toDto(Video video);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "metadata", ignore = true)
    Video toEntity(VideoDto videoDto);
}
