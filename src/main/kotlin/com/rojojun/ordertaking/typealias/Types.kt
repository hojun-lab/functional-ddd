package com.rojojun.ordertaking.`typealias`

import arrow.core.Either
import com.rojojun.ordertaking.common.CategorizedMail
import com.rojojun.ordertaking.common.EnvelopeContents
import com.rojojun.ordertaking.common.Undefined
import com.rojojun.ordertaking.domain.UnvalidatedOrder
import com.rojojun.ordertaking.domain.ValidatedOrder
import com.rojojun.ordertaking.events.PlaceOrderEvents
import com.sun.tools.javac.util.Convert

typealias QuantityType = Int
typealias OrderId = Undefined
typealias OrderLineId = Undefined
typealias CustomerId = Undefined
typealias ValidateOrder = suspend (UnvalidatedOrder) -> Either<List<Convert.Validation>, ValidatedOrder>
typealias PlaceOrder = (UnvalidatedOrder) -> PlaceOrderEvents
typealias CategorizeInboundMail = (EnvelopeContents) -> CategorizedMail
