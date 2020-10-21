package com.tw.qd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;

    @NotNull
    @Size(min = 1, max = 128)
    private String name;

    @NotNull
    @Min(17)
    private Long age;

    @NotNull
    @Size(min = 8, max = 512)
    private String avatar;

    @Size(max = 1024)
    private String description;
}
