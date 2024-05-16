package com.example.cardapio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cardapio.Model.DTO.OrderDTO;
import com.example.cardapio.Model.Entity.Client;
import com.example.cardapio.Model.Entity.Orders;
import com.example.cardapio.Repository.ClientRepository;
import com.example.cardapio.Repository.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    public List<OrderDTO> getAllOrders(){
        List<Orders> order = repository.findAll();
        List<OrderDTO> listDTO = new ArrayList<>();
        for (Orders o : order) {
            OrderDTO orderDTO = new OrderDTO(o);
            listDTO.add(orderDTO);
        }
        return listDTO;
    }

    public Optional<OrderDTO> getOrderById(Long id){
        Orders order = repository.findById(id).get();
        /*
         * Criar e adicionar exceção caso o Id não existir
         */
        OrderDTO orderDTO = new OrderDTO(order);

        return Optional.of(orderDTO);
    }


    public OrderDTO createOrder(OrderDTO newOrder){
        Orders order = new Orders(newOrder);
        //if(order != null){
        repository.save(order);
        Long orderId = repository.findById(order.getId()).get().getId();
        OrderDTO dto = new OrderDTO(order);
        dto.setId(orderId);
        return dto;
        //} 
    }

    public OrderDTO updateOrder(OrderDTO orderDTO, Long id){
        Orders order = new Orders(orderDTO);
        order.setId(id);
        repository.save(order);
        OrderDTO dto = new OrderDTO(order);

        return dto;
    }

    public String deleteOrder(Long id){
        repository.deleteById(id);

        return "Pedido deletado com sucesso!";
    }

    public List<OrderDTO> getAllByClientId(Long clientId){
        Optional<Client> client = clientRepository.findById(clientId);

        List<Long> ordersId = client.get().getOrders_Id();

        List<Orders> clientOrders = repository.findAllById(ordersId);
        List<OrderDTO> dtoOrders = new ArrayList<>();
        for (Orders order : clientOrders) {
            OrderDTO dto = new OrderDTO(order);
            dtoOrders.add(dto);
        }
        return dtoOrders;
    }

    /*
    public OrderDTO findOrderByCustomerId(Long id){
        Orders order = repository.findByClientId(id);

        OrderDTO dto = new OrderDTO(order);

        return dto;
    }
    */

    
    /*
     * create
     * read
     * update
     * delete
     * 
     */

}
