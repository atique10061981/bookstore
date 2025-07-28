// DTO
package com.bookstore.dto;
import lombok.Data;
import java.util.List;

@Data
public class OrderDTO {
    private Long customerId;
    private List<Long> bookIds;
}