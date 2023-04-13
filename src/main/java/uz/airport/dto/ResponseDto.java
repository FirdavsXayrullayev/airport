package uz.airport.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto <T> {
    private Integer code;
    private String message;
    private T data;
    private Boolean success;
}
