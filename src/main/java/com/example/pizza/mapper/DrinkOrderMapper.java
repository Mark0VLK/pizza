package com.example.pizza.mapper;

import com.example.pizza.model.DrinkOrder;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;
import com.example.pizza.response.DrinkOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        OrderMapper.class, DrinkMapper.class, InformationMapper.class
})
public interface DrinkOrderMapper {

    @Mapping(source = "productId", target = "drink")
    @Mapping(source = "orderId", target = "order")
    DrinkOrder createRequestToDrinkOrder(ProductOrderCreateRequest createRequest);

    @Mapping(source = "drink.information.name", target = "name")
    @Mapping(source = "drink.information.image", target = "image")
    @Mapping(source = "drink.volume", target = "volume")
    @Mapping(source = "drink.price", target = "price")
    DrinkOrderResponse drinkOrderToResponse(DrinkOrder drinkOrder);

    @Mapping(source = "productId", target = "drink")
    @Mapping(source = "orderId", target = "order")
    void updateDrinkOrderFromRequest(ProductOrderUpdateRequest updateRequest, @MappingTarget DrinkOrder drinkOrder);
}
