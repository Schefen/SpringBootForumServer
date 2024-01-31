package com.schefen.forumserver.services.content;

import com.schefen.forumserver.entities.Content;
import com.schefen.forumserver.entities.dtos.ContentDto;
import com.schefen.forumserver.repositories.ContentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContentImpl implements ContentService{

    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<ContentDto> getAllContents(Pageable pageable) {
        Page<Content> contentPage = contentRepository.findAll(pageable);
        return contentPage.map(content -> modelMapper.map(content, ContentDto.class));
    }

    @Override
    public ContentDto findByContentName(String contentName) {
        Optional<Content> content = contentRepository.findByContentName(contentName);
        return modelMapper.map(content,ContentDto.class);
    }
}
