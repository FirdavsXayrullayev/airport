package uz.airport.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.airport.dto.ResponseDto;
import uz.airport.dto.TicketDto;
import uz.airport.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("ticket")
@RequiredArgsConstructor
public class TicketResources {
    private final TicketService ticketService;
    @PostMapping("add-ticket")
    public ResponseDto<TicketDto> addTicket(@RequestBody TicketDto ticketDto){
        return ticketService.addTicket(ticketDto);
    }
    @PatchMapping("edit-ticket")
    public ResponseDto<TicketDto> editTicket(@RequestBody TicketDto ticketDto){
        return ticketService.editTicket(ticketDto);
    }
    @GetMapping("get-all-tickets")
    public ResponseDto<List<TicketDto>> getAllTickets(){
        return ticketService.getAllTickets();
    }
    @GetMapping("get-by-id")
    public ResponseDto<TicketDto> getById(@RequestParam Integer id){
        return ticketService.getById(id);
    }
    @DeleteMapping("delete-by-id")
    public ResponseDto<TicketDto> deleteById(@RequestParam Integer id){
        return ticketService.deleteById(id);
    }
}
