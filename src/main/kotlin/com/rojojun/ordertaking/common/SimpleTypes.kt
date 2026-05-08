package com.rojojun.ordertaking.common

import arrow.core.Either
import arrow.core.left
import arrow.core.right

// 기본 원시타입 래퍼
@JvmInline
value class CustomerId(val value: Int)

@JvmInline
value class String50(val value: String) {
    init {
        require(value.length <= 50) { "String50 cannot be greater than 50" }
    }
}

@JvmInline
value class EmailAddress(val value: String) {
    init {
        require('@' in value) { "EmailAddress cannot have an address" }
    }
}

@JvmInline
value class ZipCode(val value: String) {
    init {
        require(value.length == 5) { "ZipCode cannot be 5 characters" }
    }
}

@JvmInline
value class OrderId(val value: String)

@JvmInline
value class OrderLineId(val value: String)

@JvmInline
value class Price(val value: Double) {
    init {
        require(value in 0.0..1000.0) { "Price cannot be negative" }
    }
}

@JvmInline
value class BillingAmount(val value: Double) {
    init {
        require(value in 0.0..10000.0) { "BillingAmount cannot be negative" }
    }
}

// 주문 수량
@JvmInline
value class UnitQuantity private constructor(val value: Int) {
    companion object {
        operator fun invoke(i: Int): Either<ErrPrimitiveConstraints, UnitQuantity> =
            when {
                i < 1 -> ErrPrimitiveConstraints.ErrNumberLessThanMin(1).left()
                i > 1000 -> ErrPrimitiveConstraints.ErrNumberGreaterThanMax(1000).left()
                else -> UnitQuantity(i).right()
            }
    }
}

@JvmInline
value class KilogramQuantity private constructor(val value: Double) {
    companion object {
        operator fun invoke(i: Double): Either<ErrPrimitiveConstraints, KilogramQuantity> =
            when {
                i < 0.05 -> ErrPrimitiveConstraints.ErrNumberLessThanMin(0.05).left()
                i > 100.0 -> ErrPrimitiveConstraints.ErrNumberGreaterThanMax(100.0).left()
                else -> KilogramQuantity(i).right()
            }
    }
}

sealed interface OrderQuantity {
    @JvmInline
    value class Unit(val quantity: UnitQuantity) : OrderQuantity

    @JvmInline
    value class Kilogram(val quantity: KilogramQuantity) : OrderQuantity
}

// 상품 코드
@JvmInline
value class WidgetCode(val value: String) {
    init {
        require(value.matches(Regex("W\\d{4}"))) { "WidgetCode should be at least 4 digits and start with 'W'." }
    }
}

@JvmInline
value class GizmoCode(val value: String) {
    init {
        require(value.matches(Regex("G\\{3}"))) { "GizmoCode should be at least 3 digits and start with 'G'." }
    }
}

@JvmInline
value class EnvelopeContents(val value: String)

@JvmInline
value class InvoiceId(val value: String)

sealed interface ProductCode {
    @JvmInline
    value class Widget(val code: WidgetCode) : ProductCode

    @JvmInline
    value class Gizmo(val code: GizmoCode) : ProductCode
}

sealed interface PlaceOrderError

@JvmInline
value class ValidationError(val value: String) : PlaceOrderError
