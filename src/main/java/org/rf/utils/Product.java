package org.rf.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String title;
    private String username;
    private String size;
    private String price;
    private String information;

}
