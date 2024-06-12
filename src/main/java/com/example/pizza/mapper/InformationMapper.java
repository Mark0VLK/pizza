package com.example.pizza.mapper;

import com.example.pizza.model.Information;
import com.example.pizza.request.information.InformationCreateRequest;
import com.example.pizza.response.InformationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {CategoryMapper.class})
public interface InformationMapper {

    @Mapping(source = "categoryId", target = "category")
    Information createRequestToInformation(InformationCreateRequest informationCreateRequest);
    @Mapping(source = "category.id", target = "categoryId")
    InformationResponse informationToResponse(Information information);
    List<InformationResponse> informationListToResponses(List<Information> informationList);
    @Mapping(target = "id", source = "informationId")
    Information toEntity(Long informationId);
}
