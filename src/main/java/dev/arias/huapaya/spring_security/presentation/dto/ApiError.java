package dev.arias.huapaya.spring_security.presentation.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiError {

    public String backendMessage;

    public String url;

    public String method;

    public String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    public LocalDateTime timestamp;

}
