package com.example.demo.order.presentation;

import com.example.demo.order.application.OrderService;
import com.example.demo.order.application.dto.OrderInfo;
import com.example.demo.order.presentation.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderInfo> create(@RequestBody OrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.create(request.toCommand()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderInfo> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderInfo>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @PatchMapping("/{id}/settle")
    public ResponseEntity<OrderInfo> settle(@PathVariable UUID id,
                                            @RequestParam UUID batchId,
                                            @RequestParam UUID actorId) {
        return ResponseEntity.ok(orderService.settle(id, batchId, actorId));
    }
}
