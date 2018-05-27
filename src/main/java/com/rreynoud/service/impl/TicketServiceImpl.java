package com.rreynoud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rreynoud.api.repository.ChangeStatusRepository;
import com.rreynoud.api.repository.TicketRepository;
import com.rreynoud.entity.ChangeStatus;
import com.rreynoud.entity.Ticket;
import com.rreynoud.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ChangeStatusRepository changeRepository;
	
	@Override
	public Ticket createOrUpdateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket findById(String id) {
		Optional<Ticket> optional = this.ticketRepository.findById(id); 
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	@Override
	public void deleteTicket(String id) {
		this.ticketRepository.delete(findById(id));
	}

	@Override
	public Page<Ticket> listTicket(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findAll(pages);
	}

	@Override
	public ChangeStatus createChangeStatus(ChangeStatus change) {
		return this.changeRepository.save(change);
	}

	@Override
	public Iterable<ChangeStatus> listChangeStatus(String idTicket) {
		return this.changeRepository.findByTicketIdOrderByDateChangeStatusDesc(idTicket);
	}

	@Override
	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByUserIdOrderByDateDesc(pages, userId);
	}

	@Override
	public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository
					.findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignUserOrderByDateDesc(title, status, priority, pages);
	}

	@Override
	public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status,String priority, String idUser) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByUserIdOrderByDateDesc(pages, idUser);
	}

	@Override
	public Page<Ticket> findByNumber(int page, int count, Integer number) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByNumber(number, pages);
	}

	@Override
	public Iterable<Ticket> findAll() {
		return this.ticketRepository.findAll();
	}

	@Override
	public Page<Ticket> findByParameterAndAssignedUser(int page, int count, String title, String status,String priority, String assignedId) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignUserOrderByDateDesc(title, status, priority, pages);
	}

}
