package com.dukan.controller;

import com.dukan.model.OrderDTO;
import com.dukan.model.requests.OrderRequestDTO;
import com.dukan.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getOrders(){
        return orderService.getOrders();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO getOrder(@PathVariable Long id){
        return orderService.getOrder(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody OrderRequestDTO requestDTO){
        orderService.addOrder(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@PathVariable Long id,@RequestBody OrderRequestDTO orderRequestDTO){
        orderService.updateOrder(id,orderRequestDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

}
