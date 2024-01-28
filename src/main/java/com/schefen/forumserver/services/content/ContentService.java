package com.schefen.forumserver.services.content;

import com.schefen.forumserver.entities.dtos.ContentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContentService {
    Page<ContentDto> getAllContents(Pageable pageable);
}
