package com.sfd.order;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kuldeep
 */
@Data
@AllArgsConstructor
public class Order {
    private String orderId;
    private String userName;
}
