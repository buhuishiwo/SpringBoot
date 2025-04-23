package com.haishili.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author haishili
 * @date 2025/4/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    private Integer id;
    private String brandName;
    private Company company;
    private Integer ordered;
    private String description;
    private Integer status;
}
