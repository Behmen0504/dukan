package com.dukan.service;

import com.dukan.dao.entity.OrderEntity;
import com.dukan.dao.repository.OrderRepository;
import com.dukan.dao.repository.ProductRepository;
import com.dukan.dao.repository.UserRepository;
import com.dukan.mapper.OrderMapper;
import com.dukan.model.OrderDTO;
import com.dukan.model.requests.OrderRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    /*public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
*/
    public List<OrderDTO> getOrders() {
        log.info("ActionLog.getOrder start");
        List<OrderDTO> orderDTOS = OrderMapper.INSTANCE.mapEntitiesToDtos(orderRepository.findAll());
        log.info("ActionLog.getOrder end");
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

    public void updateOrder(Long id, OrderDTO orderDTO) {
        log.info("ActionLog.updateOrder start");
        OrderEntity orderEntity = orderRepository.findById(id).get();
//        newsRepository.save(newsEntity);
        log.info("ActionLog.updateOrder end");
    }
}
