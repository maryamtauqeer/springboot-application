package com.maryamt.springbootapplication.mapper;

import com.maryamt.springbootapplication.dto.PublisherDTO;
import com.maryamt.springbootapplication.entity.Publisher;

public class PublisherMapper {
    public static PublisherDTO mapToPublisherDto(Publisher pub){
        PublisherDTO pubDTO= new PublisherDTO(
                pub.getPub_id(),
                pub.getName(),
                pub.getBooks()
        );
        return pubDTO;
    }

    public static Publisher mapToPublisher(PublisherDTO pubDTO){
        Publisher pub = new Publisher(
                pubDTO.getPub_id(),
                pubDTO.getName(),
                pubDTO.getBooks()
        );
        return pub;
    }
}
