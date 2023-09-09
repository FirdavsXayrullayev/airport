package uz.airport.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.airport.dto.ResponseDto;
import uz.airport.dto.TicketDto;
import uz.airport.model.Ticket;
import uz.airport.repository.TicketRepository;
import uz.airport.service.TicketService;
import uz.airport.service.mapper.TicketMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;

    @Override
    public ResponseDto<TicketDto> addTicket(TicketDto ticketDto) {
        try {
            return ResponseDto.<TicketDto>builder()
                    .code(1)
                    .message("OK")
                    .success(true)
                    .data(ticketMapper.toDto(ticketRepository.save(ticketMapper.toEntity(ticketDto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<TicketDto>builder()
                    .code(1)
                    .success(false)
                    .message("Database Error" + e)
                    .data(ticketDto)
                    .build();
        }
    }

    @Override
    public ResponseDto<TicketDto> editTicket(TicketDto ticketDto) {
        if (ticketDto.getId() == null) {
            return ResponseDto.<TicketDto>builder()
                    .code(-2)
                    .message("Validation Error")
                    .success(false)
                    .data(ticketDto)
                    .build();
        }
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketDto.getId());
        if (optionalTicket.isEmpty()) {
            return ResponseDto.<TicketDto>builder()
                    .code(-1)
                    .message("Not Found")
                    .data(ticketDto)
                    .success(false)
                    .build();
        }
        Ticket ticket = optionalTicket.get();
        if (ticketDto.getGender() != null) ticket.setGender(ticketDto.getGender());
        if (ticketDto.getDate() != null) ticket.setDate(ticketDto.getDate());
        if (ticketDto.getBirtDate() != null) ticket.setBirtDate(ticketDto.getBirtDate());
        if (ticketDto.getToCity() != null) ticket.setToCity(ticketDto.getToCity());
        if (ticketDto.getFromCity() != null) ticket.setFromCity(ticketDto.getFromCity());
        if (ticketDto.getFirstName() != null) ticket.setFirstName(ticketDto.getFirstName());
        if (ticketDto.getLastName() != null) ticket.setLastName(ticketDto.getLastName());
        if (ticketDto.getPhoneNumber() != null) ticket.setPhoneNumber(ticketDto.getPhoneNumber());
        try {
            ticketRepository.save(ticket);

            return ResponseDto.<TicketDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(ticketMapper.toDto(ticket))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<TicketDto>builder()
                    .code(1)
                    .message("Database Error")
                    .success(false)
                    .data(ticketDto)
                    .build();
        }

    }

    @Override
    public ResponseDto<List<TicketDto>> getAllTickets() {
        return ResponseDto.<List<TicketDto>>builder()
                .code(0)
                .message("OK")
                .success(true)
                .data(ticketRepository.findAll().stream().map(ticketMapper::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<TicketDto> deleteById(Integer id) {
        return ticketRepository.findById(id).map(ticket -> {
            ticketRepository.delete(ticket);
                    return ResponseDto.<TicketDto>builder()
                            .code(0)
                            .message("OK")
                            .success(true)
                            .data(ticketMapper.toDto(ticket))
                            .build();
                })
                .orElse(ResponseDto.<TicketDto>builder()
                        .code(-1)
                        .message("Not Found")
                        .success(false)
                        .build());
    }

    @Override
    public ResponseDto<TicketDto> getById(Integer id) {
        return ticketRepository.findById(id)
                .map(ticket -> ResponseDto.<TicketDto>builder()
                        .code(0)
                        .message("OK")
                        .data(ticketMapper.toDto(ticket))
                        .success(true)
                        .build())
                .orElse(ResponseDto.<TicketDto>builder()
                        .code(-1)
                        .message("Not Found")
                        .success(false)
                        .build());
    }
}
