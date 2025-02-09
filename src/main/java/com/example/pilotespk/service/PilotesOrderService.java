package com.example.pilotespk.service;

import com.example.pilotespk.pilotess.PilotesOrder;
import com.example.pilotespk.repository.PilotesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PilotesOrderService {

    @Autowired
    private PilotesOrderRepository repository;

    // Create a new pilotes order
    public PilotesOrder createOrder(int quantity, String status) {
        if (quantity != 5 && quantity != 10 && quantity != 15) {
            throw new IllegalArgumentException("Invalid quantity. Must be 5, 10, or 15.");
        }
        PilotesOrder order = new PilotesOrder(quantity, status);
        return repository.save(order);
    }

    // Update an existing order
    public PilotesOrder updateOrder(Long id, int quantity, String status) {
        Optional<PilotesOrder> existingOrder = repository.findById(id);
        if (existingOrder.isPresent()) {
            PilotesOrder order = existingOrder.get();
            order.setQuantity(quantity);
            order.setStatus(status);
            return repository.save(order);
        } else {
            throw new IllegalArgumentException("Order not found");
        }
    }
}
