package com.dukan.service;

import com.dukan.dao.entity.OrderDetailEntity;
import com.dukan.dao.repository.OrderDetailRepository;
import com.dukan.mapper.OrderDetailMapper;
import com.dukan.model.OrderDetailDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.OrderDetailRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public List<OrderDetailDTO> getOrderDetails() {
        log.info("ActionLog.getOrderDetails start");
        List<OrderDetailDTO> orderDetailDTOS = OrderDetailMapper.INSTANCE.mapEntitiesToDtos(orderDetailRepository.findAll());
        log.info("ActionLog.getOrderDetails end");
        return orderDetailDTOS;
    }

    public OrderDetailDTO getOrderDetail(Long id) {
        log.info("ActionLog.getOrderDetail start");
        OrderDetailDTO orderDetailDTO = OrderDetailMapper.INSTANCE.mapEntityToDto(orderDetailRepository.findById(id).get());
        log.info("ActionLog.getOrderDetail end");
        return orderDetailDTO;
    }
    public void addOrderDetail(OrderDetailRequestDTO requestDTO) {
        log.info("ActionLog.addOrderDetail start");
        OrderDetailEntity orderDetailEntity = OrderDetailMapper.INSTANCE.mapOrderDetailRequestDtoToEntity(requestDTO);
        orderDetailRepository.save(orderDetailEntity);
        log.info("ActionLog.addOrderDetail end");
    }

    public void updateOrderDetail(Long id, OrderDetailRequestDTO orderDetailRequestDTO) {
        log.info("ActionLog.updateOrderDetail start");
        OrderDetailEntity orderDetailEntity = orderDetailRepository.findById(id).get();
//        newsRepository.save(orderDetailEntity);
        log.info("ActionLog.updateOrderDetail end");
    }
    public void deleteOrderDetail(Long id) {
        log.info("ActionLog.deleteOrderDetail start");
        orderDetailRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.deleteOrderDetail.error order detail not found with id: {}", id);
                    throw new NotFoundException("ORDERDETAIL_NOT_FOUND");
                }
        );
        log.info("ActionLog.deleteOrderDetail end");
        orderDetailRepository.deleteById(id);
    }
}
