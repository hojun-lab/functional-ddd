package com.kalrap.ordertaking.domain

import com.kalrap.ordertaking.common.Undefined

typealias CustomerInfo = Undefined
typealias ShippingAddress = Undefined
typealias BillingAddress = Undefined
typealias OrderLine = Undefined

class Order (
    val customerInfo: CustomerInfo,
    val shippingAddress: ShippingAddress,
    val billingAddress: BillingAddress,
    val orderLines: List<OrderLine>,
    val amountToBill: BillingAmount,
) {}
