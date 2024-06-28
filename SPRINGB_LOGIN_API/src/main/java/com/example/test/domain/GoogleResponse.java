package com.example.test.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
public class GoogleResponse {
    // Getters and setters
    private String id_token;
    private String access_token;

}