package com.example.cardapio.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.Model.DTO.OrderDTO;
import com.example.cardapio.Model.DTO.OrderRequest;
import com.example.cardapio.Model.DTO.OrderResponse;
import com.example.cardapio.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    
    @Autowired
    private OrderService service;

    @GetMapping()
    public ResponseEntity<List<OrderResponse>> getAllOrders(){;

        List<OrderDTO> listDTO = service.getAllOrders();
        List<OrderResponse> listResponse = new ArrayList<>();

        for(OrderDTO dto : listDTO) {
            OrderResponse response = new OrderResponse(dto);
            listResponse.add(response);
        }
        return new ResponseEntity<>(listResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getByOrderId(@PathVariable Long orderId){
        Optional<OrderDTO> orderDTO = service.getOrderById(orderId);

        OrderResponse orderResponse = new OrderResponse(orderDTO.get());

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<OrderResponse> createNewOrder(@RequestBody OrderDTO dto){
        OrderDTO orderWithId = service.createOrder(dto);
        OrderResponse response = new OrderResponse(orderWithId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderResponse> updateOrder(@RequestBody OrderRequest order, @PathVariable Long orderId){
        OrderDTO dto = new OrderDTO();
        OrderDTO.fromOrderRequest(order);
        service.updateOrder(dto, orderId);

        OrderResponse response = new OrderResponse(dto);

        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        service.deleteOrder(id);
        
        return new ResponseEntity<>("Order sucessfuly deleted", HttpStatus.OK);
    }
}
