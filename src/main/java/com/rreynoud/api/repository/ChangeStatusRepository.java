package com.rreynoud.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rreynoud.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatus(String ticketId);
	
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String idTicket);
	
}
