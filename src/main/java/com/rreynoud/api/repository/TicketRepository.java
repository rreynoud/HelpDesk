package com.rreynoud.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.rreynoud.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, String userId);
	 
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityIgnoreCaseContainingOrderByDateDesc(String title, String status, String priority, Pageable pages);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignUserOrderByDateDesc(String title, String status, String priority,  Pageable pages);
	
	Page<Ticket> findByNumber(Integer number, Pageable pages);
}
