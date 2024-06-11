package com.example.pizza.controller;

import com.example.pizza.request.location.LocationCreateRequest;
import com.example.pizza.request.location.LocationUpdateRequest;
import com.example.pizza.response.LocationResponse;
import com.example.pizza.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<LocationResponse>> getAllLocations() {
        List<LocationResponse> locationsResponse = locationService.getAllLocations();
        return new ResponseEntity<>(locationsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponse> getLocationById(@PathVariable Long id) {
        LocationResponse locationResponse = locationService.getLocationById(id);
        return new ResponseEntity<>(locationResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationResponse> create(@RequestBody LocationCreateRequest locationCreateRequest) {
        LocationResponse locationResponse = locationService.create(locationCreateRequest);
        return new ResponseEntity<>(locationResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationResponse> update(@PathVariable Long id,
                                                   @RequestBody LocationUpdateRequest locationUpdateRequest) {
        LocationResponse locationResponse = locationService.update(id, locationUpdateRequest);
        return new ResponseEntity<>(locationResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LocationResponse> delete(@PathVariable Long id) {
        LocationResponse locationResponse = locationService.deleteById(id);
        return new ResponseEntity<>(locationResponse, HttpStatus.OK);
    }
}
