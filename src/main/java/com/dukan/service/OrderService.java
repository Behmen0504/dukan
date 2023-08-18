package com.dukan.service;

import com.dukan.dao.entity.OrderEntity;
import com.dukan.dao.repository.OrderRepository;
import com.dukan.dao.repository.ProductRepository;
import com.dukan.dao.repository.UserRepository;
import com.dukan.mapper.OrderMapper;
import com.dukan.model.OrderDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.OrderRequestDTO;
import com.dukan.myenums.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderDTO> getOrders() {
        log.info("ActionLog.getOrders start");
        List<OrderDTO> orderDTOS = OrderMapper.INSTANCE.mapEntitiesToDtos(orderRepository.getOrderEntitiesByStatus(Status.ENABLE));
        log.info("ActionLog.getOrders end");
        return orderDTOS;
    }

    public OrderDTO getOrder(Long id) {
        log.info("ActionLog.getOrder start");
        OrderDTO orderDTO = OrderMapper.INSTANCE.mapEntityToDto(orderRepository.findById(id).get());
        log.info("ActionLog.getOrder end");
        return orderDTO;
    }
    public void addOrder(OrderRequestDTO requestDTO) {
        log.info("ActionLog.addOrder start");
        OrderEntity orderEntity = OrderMapper.INSTANCE.mapOrderRequestDtoToEntity(requestDTO);
        orderRepository.save(orderEntity);
        log.info("ActionLog.addOrder end");
    }

    public void updateOrder(Long id, OrderRequestDTO requestDTO) {
        log.info("ActionLog.updateOrder start");
        OrderEntity orderEntity = orderRepository.findById(id).get();
//        newsRepository.save(newsEntity);
        log.info("ActionLog.updateOrder end");
    }
    public void deleteOrder(Long id) {
        log.info("ActionLog.deleteOrder start");
        orderRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.deleteOrder.error order not found with id: {}", id);
                    throw new NotFoundException("ORDER_NOT_FOUND");
                }
        );
        log.info("ActionLog.deleteOrder end");
        orderRepository.deleteById(id);
    }
}
