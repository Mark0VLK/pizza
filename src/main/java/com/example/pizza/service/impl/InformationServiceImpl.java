package com.example.pizza.service.impl;

import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.mapper.InformationMapper;
import com.example.pizza.model.Category;
import com.example.pizza.model.Information;
import com.example.pizza.repositories.CategoryRepository;
import com.example.pizza.repositories.InformationRepository;
import com.example.pizza.request.information.InformationCreateRequest;
import com.example.pizza.request.information.InformationUpdateRequest;
import com.example.pizza.response.InformationResponse;
import com.example.pizza.service.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationServiceImpl implements InformationService {

    private final InformationRepository informationRepository;
    private final InformationMapper informationMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public InformationResponse deleteById(Long id) {
        Information information = informationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("information", id));
        informationRepository.delete(information);
        return informationMapper.informationToResponse(information);
    }

    @Override
    public InformationResponse create(InformationCreateRequest informationCreateRequest) {
        Information information = informationMapper.createRequestToInformation(informationCreateRequest);
        informationRepository.save(information);
        return informationMapper.informationToResponse(information);
    }

    @Override
    public InformationResponse update(Long id, InformationUpdateRequest informationUpdateRequest) {
        Information information = informationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("information", id));
        Category category = categoryRepository.findById(informationUpdateRequest.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("category", informationUpdateRequest.categoryId()));
        updateInformationFields(information, informationUpdateRequest, category);
        informationRepository.save(information);
        return informationMapper.informationToResponse(information);
    }

    private void updateInformationFields(Information information, InformationUpdateRequest request, Category category) {
        information.setName(request.name());
        information.setDescription(request.description());
        information.setEnergyValue(request.energyValue());
        information.setProteins(request.proteins());
        information.setFat(request.fat());
        information.setCarb(request.carb());
        information.setCategory(category);
        information.setImage(request.image());
    }

    @Override
    public InformationResponse getInformationById(Long id) {
        Information information = informationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("information", id));
        return informationMapper.informationToResponse(information);
    }

    @Override
    public List<InformationResponse> getAllInformation() {
        List<Information> informationList = informationRepository.findAll();
        return informationMapper.informationListToResponses(informationList);
    }
}
