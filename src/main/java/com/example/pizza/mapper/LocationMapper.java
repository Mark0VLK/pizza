package com.example.pizza.mapper;

import com.example.pizza.model.Location;
import com.example.pizza.request.location.LocationCreateRequest;
import com.example.pizza.response.LocationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    Location createRequestToLocation(LocationCreateRequest locationCreateRequest);

    LocationResponse locationToResponse(Location location);

    List<LocationResponse> locationsToResponses(List<Location> locations);
}