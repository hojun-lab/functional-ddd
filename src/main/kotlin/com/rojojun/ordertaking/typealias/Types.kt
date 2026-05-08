package com.rojojun.ordertaking.`typealias`

import com.rojojun.ordertaking.common.Undefined
import com.rojojun.ordertaking.domain.UnvalidatedOrder
import com.rojojun.ordertaking.events.PlaceOrderEvents

typealias QuantityType = Int
typealias OrderId = Undefined
typealias OrderLineId = Undefined
typealias CustomerId = Undefined
typealias PlaceOrder = (UnvalidatedOrder) -> PlaceOrderEvents
