package com.rojojun.ordertaking.domain

import com.rojojun.ordertaking.common.*

typealias CustomerInfo = Undefined
typealias ShippingAddress = Undefined
typealias BillingAddress = Undefined

class Order(
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

class OrderLine(
    val orderLineId: OrderLineId,
    val orderId: OrderId,
    val productCode: ProductCode,
    val orderQuantity: OrderQuantity,
    val price: Price,
) : Entity<OrderLineId>() {
    override val id: OrderLineId
        get() = orderLineId
}
