package com.rojojun.ordertaking.events

data class PlaceOrderEvents(
    val acknowledgmentSent: AcknowledgmentSent,
    val orderPlaced: OrderPlaced,
    val billableOrderPlaced: BillableOrderPlaced,
)
