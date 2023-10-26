package com.cardonamaturana.transportms.infrastructure.api.mapper.order;

import com.cardonamaturana.transportms.domain.entity.Order;
import com.cardonamaturana.transportms.infrastructure.api.dto.order.OrderRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface OrderRequestMapper {

  Order toEntity(OrderRequest orderRequest);


}
