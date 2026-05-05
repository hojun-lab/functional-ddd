package com.rojojun.ordertaking.domain

import com.rojojun.ordertaking.common.Entity
import com.rojojun.ordertaking.common.Undefined

typealias CustomerInfo = Undefined
typealias ShippingAddress = Undefined
typealias BillingAddress = Undefined
typealias OrderLine = Undefined

class Order (
    val orderId: OrderId,
    val customerId: CustomerId,
    val orderLines: List<OrderLine>,
    val shippingAddress: ShippingAddress,
    val billingAddress: BillingAddress,
    val amountToBill: BillingAmount,
) : Entity<OrderId>() {
    override val id: OrderId
        get() = orderId
}
