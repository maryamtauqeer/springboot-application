package com.maryamt.springbootapplication.mapper;

import com.maryamt.springbootapplication.dto.BookDTO;
import com.maryamt.springbootapplication.dto.PublisherDTO;
import com.maryamt.springbootapplication.entity.Book;
import com.maryamt.springbootapplication.entity.Publisher;

import java.util.ArrayList;
import java.util.List;

public class PublisherMapper {
    public static PublisherDTO mapToPublisherDto(Publisher pub){

        PublisherDTO pubDTO= new PublisherDTO(
                pub.getPub_id(),
                pub.getName(),
//                BookMapper.mapToBookDTOsList(pub.getBooks())
                BookPublisherMapper.mapBooksDTO(pub.getBooks(), pub.getPub_id())
        );
        return pubDTO;
    }

    public static Publisher mapToPublisher(PublisherDTO pubDTO){
        Publisher pub = new Publisher(
                pubDTO.getPub_id(),
                pubDTO.getName(),
//                BookMapper.mapToBooksList(pubDTO.getBooks())
                BookPublisherMapper.mapToBooks(pubDTO.getBooks())
        );
        return pub;
    }

    public static List<Publisher> mapToPubList(List<PublisherDTO> pubDTOs) {
        List<Publisher> pubs = new ArrayList<>();
        for (PublisherDTO publisherDTO : pubDTOs ){
            pubs.add(mapToPublisher(publisherDTO));
        }
        return pubs;
    }

    public static List<PublisherDTO> mapToPubDTOsList(List<Publisher> pubs) {
        List<PublisherDTO> pubDTOs = new ArrayList<>();
        for (Publisher pub : pubs) {
            pubDTOs.add(mapToPublisherDto(pub));
        }
        return pubDTOs;
    }
}
