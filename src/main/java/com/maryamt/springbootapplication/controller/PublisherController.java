package com.maryamt.springbootapplication.controller;

import com.maryamt.springbootapplication.dto.PublisherDTO;
import com.maryamt.springbootapplication.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/publishers")
public class PublisherController {
    private PublisherService publisherService;

    @PostMapping
    public ResponseEntity<PublisherDTO> createPublisher(@RequestBody PublisherDTO publisherDTO){
        PublisherDTO savedPub=publisherService.createPublisher(publisherDTO);
        return new ResponseEntity<>(savedPub, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable("id") Long pub_id){
        PublisherDTO publisherDTO=publisherService.getPublisherById(pub_id);
        return new ResponseEntity<>(publisherDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PublisherDTO>> getPublishers(){
        List<PublisherDTO> publishers=publisherService.getAllPublishers();
        return new ResponseEntity<>(publishers, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<PublisherDTO> updatePublisher(@PathVariable("id")Long pub_id, @RequestBody PublisherDTO publisherDTO){
        publisherDTO.setPub_id(pub_id);
        PublisherDTO updatedPublisher =publisherService.updatePublisher(publisherDTO);
        return new ResponseEntity<>(updatedPublisher, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable("id")Long id){
        publisherService.deletePublisher(id);
        return new ResponseEntity<>("Genre deleted successfully.",HttpStatus.OK);
    }


}
