package com.rojojun.ordertaking.events

import com.rojojun.ordertaking.common.Undefined

typealias AcknowledgmentSent = Undefined
typealias OrderPlaced = Undefined
typealias BillableOrderPlaced = Undefined

data class PlaceOrderEvents(
    val acknowledgmentSent: AcknowledgmentSent,
    val orderPlaced: OrderPlaced,
    val billableOrderPlaced: BillableOrderPlaced,
)
