package com.dukan.controller;

import com.dukan.model.OrderDetailDTO;
import com.dukan.model.requests.OrderDetailRequestDTO;
import com.dukan.service.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/orderdetails")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDetailDTO> getOrderDetails(){
        return orderDetailService.getOrderDetails();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDetailDTO getOrderDetail(@PathVariable Long id){
        return orderDetailService.getOrderDetail(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrderDetail(@RequestBody OrderDetailRequestDTO requestDTO){
        orderDetailService.addOrderDetail(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrderDetail(@PathVariable Long id,@RequestBody OrderDetailRequestDTO orderDetailRequestDTO){
        orderDetailService.updateOrderDetail(id,orderDetailRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderDetail(@PathVariable Long id){
        orderDetailService.deleteOrderDetail(id);
    }

}
