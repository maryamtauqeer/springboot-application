package com.maryamt.springbootapplication.service;

import com.maryamt.springbootapplication.dto.PublisherDTO;

import java.util.List;

public interface PublisherService {
    PublisherDTO createPublisher(PublisherDTO publisherDTO);

    PublisherDTO getPublisherById(Long pub_id);

    List<PublisherDTO> getAllPublishers();

    PublisherDTO updatePublisher(PublisherDTO publisherDTO);

    void deletePublisher(Long pub_id);
}
