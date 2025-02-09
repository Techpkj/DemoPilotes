package com.example.pilotespk.controller;



import com.example.pilotespk.pilotess.PilotesOrder;
import com.example.pilotespk.service.PilotesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pilotes")
public class PilotesOrderController {

    @Autowired
    private PilotesOrderService service;

    // Create a new order
    @PostMapping("/order")
    public ResponseEntity<PilotesOrder> createOrder(@RequestParam int quantity, @RequestParam String status) {
        try {
            PilotesOrder order = service.createOrder(quantity, status);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Update an existing order
    @PutMapping("/order/{id}")
    public ResponseEntity<PilotesOrder> updateOrder(@PathVariable Long id, @RequestParam int quantity, @RequestParam String status) {
        try {
            PilotesOrder updatedOrder = service.updateOrder(id, quantity, status);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
