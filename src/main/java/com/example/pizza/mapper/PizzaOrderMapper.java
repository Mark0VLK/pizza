package com.example.pizza.mapper;

import com.example.pizza.model.PizzaOrder;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;
import com.example.pizza.response.PizzaOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        OrderMapper.class, PizzaMapper.class, InformationMapper.class
})
public interface PizzaOrderMapper {

    @Mapping(source = "productId", target = "pizza")
    @Mapping(source = "orderId", target = "order")
    PizzaOrder createRequestToPizzaOrder(ProductOrderCreateRequest createRequest);

    @Mapping(source = "pizza.information.name", target = "name")
    @Mapping(source = "pizza.information.image", target = "image")
    @Mapping(source = "pizza.diameter", target = "diameter")
    @Mapping(source = "pizza.weight", target = "weight")
    @Mapping(source = "pizza.price", target = "price")
    PizzaOrderResponse pizzaOrderToResponse(PizzaOrder pizzaOrder);

    @Mapping(source = "productId", target = "pizza")
    @Mapping(source = "orderId", target = "order")
    void updatePizzaOrderFromRequest(ProductOrderUpdateRequest updateRequest, @MappingTarget PizzaOrder pizzaOrder);
}
