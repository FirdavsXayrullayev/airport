package uz.airport.service;

import uz.airport.dto.ResponseDto;
import uz.airport.dto.TicketDto;
import java.util.List;

public interface TicketService {
    ResponseDto<TicketDto> addTicket(TicketDto ticketDto);

    ResponseDto<TicketDto> editTicket(TicketDto ticketDto);

    ResponseDto<List<TicketDto>> getAllTickets();

    ResponseDto<TicketDto> deleteById(Integer id);

    ResponseDto<TicketDto> getById(Integer id);
}
