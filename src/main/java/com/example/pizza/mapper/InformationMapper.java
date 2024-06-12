package com.example.pizza.mapper;

import com.example.pizza.model.Information;
import com.example.pizza.request.information.InformationCreateRequest;
import com.example.pizza.response.InformationResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface InformationMapper {
    Information createRequestToInformation(InformationCreateRequest informationCreateRequest);
    InformationResponse informationToResponse(Information information);
    List<InformationResponse> informationListToResponses(List<Information> informationList);
}
