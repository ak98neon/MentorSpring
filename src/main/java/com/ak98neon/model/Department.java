package com.ak98neon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Artem Kudria
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Department {
    public static final String TABLE_NAME = "DEPARTMENT";
    public static final String ID_COLUMN = "ID";
    public static final String NAME_COLUMN = "NAME";

    private Long id;
    private String name;
}
