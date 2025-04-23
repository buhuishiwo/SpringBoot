package com.haishili.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author haishili
 * @date 2025/4/15
 */
//lombok注解，@Data表示同时使用@Getter、@Setter、@ToString、@EqualsAndHashCode 和 @RequiredArgsConstructor
@Data
//@AllArgsConstructor生成有参构造
//@NoArgsConstructor生成无参构造
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer deptid;
    private String name;
}
