package com.rreynoud.service;

import org.springframework.data.domain.Page;

import com.rreynoud.entity.ChangeStatus;
import com.rreynoud.entity.Ticket;

public interface TicketService {


	Ticket createOrUpdateTicket(Ticket ticket);
	
	Ticket findById(String id);
	
	void deleteTicket(String id);
	
	Page<Ticket> listTicket(int page, int count);
	
	ChangeStatus createChangeStatus(ChangeStatus change);
	
	Iterable<ChangeStatus> listChangeStatus(String idTicket);
	
	Page<Ticket> findByCurrentUser(int page, int count, String userId);
	
	Page<Ticket> findByParameters(int page, int count,String title, String status, String priority);
	
	Page<Ticket> findByParametersAndCurrentUser(int page, int count,String title, String status, String priority,String idUser);
	
	Page<Ticket> findByNumber(int page, int count,Integer number);
	
	Iterable<Ticket> findAll();
	
	Page<Ticket> findByParameterAndAssignedUser(int page, int count,String title,String status, String priority, String assignedId);	
	
}
