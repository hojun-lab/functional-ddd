package com.rojojun.ordertaking.domain

data class UnvalidatedOrder(
    val orderId: String,
    val customInfo: UnvalidatedCustomInfo,
    val shippingAddress: UnvalidatedAddress,
)

data class UnvalidatedCustomInfo(
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
)

data class UnvalidatedAddress(
    val addressLine1: String,
    val addressLine2: String,
    val addressLine3: String,
    val addressLine4: String,
    val city: String,
    val zipCode: String,
)