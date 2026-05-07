package com.rojojun.ordertaking.common

// 기본 원시타입 래퍼
@JvmInline value class CustomerId (val value: Int)
@JvmInline value class String50 (val value: String) {
    init {
        require(value.length <= 50) { "String50 cannot be greater than 50" }
    }
}
@JvmInline value class EmailAddress (val value: String) {
    init {
        require('@' in value) { "EmailAddress cannot have an address" }
    }
}
@JvmInline value class ZipCode (val value: String) {
    init {
        require(value.length == 5) { "ZipCode cannot be 5 characters" }
    }
}
@JvmInline value class OrderId(val value: String)
@JvmInline value class OrderLineId(val value: String)
@JvmInline value class Price (val value: Double) {
    init {
        require(value in 0.0..1000.0) { "Price cannot be negative" }
    }
}
@JvmInline value class BillingAmount(val value: Double) {
    init {
        require(value in 0.0..10000.0) { "BillingAmount cannot be negative" }
    }
}

// 주문 수량
@JvmInline value class UnitQuantity private constructor (val value: Int) {
    companion object {
        operator fun invoke(i: Int):
    }
    init {
        require(value in 1..1000) { "UnitQuantity cannot be greater than 1000" }
    }
}
@JvmInline value class KilogramQuantity (val value: Double) {
    init {
        require(value in 0.05..100.0) { "KilogramQuantity cannot be greater than 100.0" }
    }
}

sealed interface OrderQuantity {
    @JvmInline value class Unit(val quantity: UnitQuantity): OrderQuantity
    @JvmInline value class Kilogram(val quantity: KilogramQuantity): OrderQuantity
}

// 상품 코드
@JvmInline value class WidgetCode (val value: String) {
    init {
        require(value.matches(Regex("W\\d{4}"))) { "WidgetCode should be at least 4 digits and start with 'W'." }
    }
}
@JvmInline value class GizmoCode (val value: String) {
    init {
        require(value.matches(Regex("G\\{3}"))) { "GizmoCode should be at least 3 digits and start with 'G'." }
    }
}

@JvmInline
value class EnvelopeContents ( val value: String )

@JvmInline
value class InvoiceId()

sealed interface ProductCode {
    @JvmInline value class Widget(val code: WidgetCode): ProductCode
    @JvmInline value class Gizmo(val code: GizmoCode): ProductCode
}

sealed interface CategorizedMail {
    data class QuoteForm(): CategorizedMail
    data class OrderForm(): CategorizedMail
}

sealed interface InvoiceInfo {
    data class UnpaidInvoiceInfo(): InvoiceInfo
    data class PaidInvoiceInfo(): InvoiceInfo
}
