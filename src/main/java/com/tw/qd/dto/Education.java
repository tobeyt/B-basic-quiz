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
public class Education {
    private Long userId;

    @NotNull
    // TODO GTB-3: - 是不是对历年的理解有什么误会？
    // TODO GTB-3: - 校验失败时应该给出清晰的message
    @Min(1900)
    @Max(2100)
    private Long year;

    @NotNull
    @Size(min = 1, max = 256)
    private String title;

    @NotNull
    @Size(min = 1, max = 4096)
    private String description;
}
