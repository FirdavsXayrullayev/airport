package uz.airport.service.mapper;

import org.mapstruct.Mapper;
import uz.airport.dto.TicketDto;
import uz.airport.model.Ticket;

@Mapper(componentModel = "spring")
public abstract class TicketMapper implements CommonMapper<TicketDto, Ticket>{
}
