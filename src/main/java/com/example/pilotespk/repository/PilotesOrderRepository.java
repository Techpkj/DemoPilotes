package com.example.pilotespk.repository;

import com.example.pilotespk.pilotess.PilotesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotesOrderRepository extends JpaRepository<PilotesOrder, Long> {
}