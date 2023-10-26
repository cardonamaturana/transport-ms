package com.cardonamaturana.transportms.infrastructure.repository.order;

import com.cardonamaturana.transportms.domain.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface OrderMapper {

  Order toEntity(OrderDto orderDto);

  OrderDto toDto(Order order);

}
