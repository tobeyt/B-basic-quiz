package com.tw.qd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    private Long userId;

    private Long year;

    private String title;

    private String description;
}
