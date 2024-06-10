package com.example.pizza.service.impl;

import com.example.pizza.request.InformationCreateRequest;
import com.example.pizza.response.InformationResponse;
import com.example.pizza.service.InformationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Override
    public InformationResponse deleteById(Long id) {

        return null;
    }

    @Override
    public InformationResponse create(InformationCreateRequest informationCreateRequest) {

        return null;
    }

    @Override
    public InformationResponse update(Long id, InformationCreateRequest informationCreateRequest) {

        return null;
    }

    @Override
    public InformationResponse getInformationById(Long id) {

        return null;
    }

    @Override
    public List<InformationResponse> getAllInformation() {

        return null;
    }
}
