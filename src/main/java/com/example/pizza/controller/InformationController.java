package com.example.pizza.controller;

import com.example.pizza.request.information.InformationCreateRequest;
import com.example.pizza.request.information.InformationUpdateRequest;
import com.example.pizza.service.InformationService;
import com.example.pizza.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/information")
public class InformationController {

    private final InformationService informationService;

    @GetMapping
    public ResponseEntity<List<InformationResponse>> getAllInformation() {
        List<InformationResponse> informationResponses = informationService.getAllInformation();
        return new ResponseEntity<>(informationResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformationResponse> getInformationById(@PathVariable("id") Long id) {
        InformationResponse informationResponses = informationService.getInformationById(id);
        return new ResponseEntity<>(informationResponses, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<InformationResponse> create(@RequestBody InformationCreateRequest informationCreateRequest) {
        InformationResponse informationResponses = informationService.create(informationCreateRequest);
        return new ResponseEntity<>(informationResponses, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformationResponse> update(@PathVariable("id") Long id,
                                                      @RequestBody InformationUpdateRequest informationUpdateRequest) {
        InformationResponse informationResponses = informationService.update(id, informationUpdateRequest);
        return new ResponseEntity<>(informationResponses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InformationResponse> deleteInformation(@PathVariable("id") Long id) {
        InformationResponse informationResponses = informationService.deleteById(id);
        return new ResponseEntity<>(informationResponses, HttpStatus.OK);
    }
}
