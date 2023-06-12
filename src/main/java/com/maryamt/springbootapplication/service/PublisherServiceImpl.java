package com.maryamt.springbootapplication.service;

import com.maryamt.springbootapplication.dto.PublisherDTO;
import com.maryamt.springbootapplication.entity.Publisher;
import com.maryamt.springbootapplication.mapper.PublisherMapper;
import com.maryamt.springbootapplication.repository.PublisherRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService{
    @Autowired
    private PublisherRepo publisherRepo;
    @Override
    public PublisherDTO createPublisher(PublisherDTO publisherDTO) {
        Publisher pub = PublisherMapper.mapToPublisher(publisherDTO);
        Publisher savedPub= publisherRepo.save(pub);
        return PublisherMapper.mapToPublisherDto(savedPub);
    }

    @Override
    public PublisherDTO getPublisherById(Long pub_id) {
        Optional<Publisher> optionalPublisher=publisherRepo.findById(pub_id);
        Publisher pub= optionalPublisher.get();
        return PublisherMapper.mapToPublisherDto(pub);
    }

    @Override
    public List<PublisherDTO> getAllPublishers() {
        List<Publisher> publishers=publisherRepo.findAll();
        return publishers.stream().map(PublisherMapper::mapToPublisherDto).collect(Collectors.toList());
    }

    @Override
    public PublisherDTO updatePublisher(PublisherDTO publisherDTO) {
        Publisher pub = PublisherMapper.mapToPublisher(publisherDTO);
        Publisher existingPublisher = publisherRepo.findById(pub.getPub_id()).get();
        existingPublisher.setName(pub.getName());
        existingPublisher.setBooks(pub.getBooks());
        Publisher updatedPublisher=publisherRepo.save(existingPublisher);
        return PublisherMapper.mapToPublisherDto(updatedPublisher);
    }

    @Override
    public void deletePublisher(Long pub_id) {
        publisherRepo.deleteById(pub_id);
    }
}
