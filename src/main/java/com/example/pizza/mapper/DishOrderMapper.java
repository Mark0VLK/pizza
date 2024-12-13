package com.example.pizza.mapper;

import com.example.pizza.model.DishOrder;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;
import com.example.pizza.response.DishOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        OrderMapper.class, DishMapper.class, InformationMapper.class
})
public interface DishOrderMapper {

    @Mapping(source = "productId", target = "dish")
    @Mapping(source = "orderId", target = "order")
    DishOrder createRequestToDishOrder(ProductOrderCreateRequest createRequest);

    @Mapping(source = "dish.information.name", target = "name")
    @Mapping(source = "dish.information.image", target = "image")
    @Mapping(source = "dish.numberOfPieces", target = "numberOfPieces")
    @Mapping(source = "dish.weight", target = "weight")
    @Mapping(source = "dish.price", target = "price")
    DishOrderResponse dishOrderToResponse(DishOrder dishOrder);

    @Mapping(source = "productId", target = "dish")
    @Mapping(source = "orderId", target = "order")
    void updateDishOrderFromRequest(ProductOrderUpdateRequest updateRequest, @MappingTarget DishOrder dishOrder);
}
