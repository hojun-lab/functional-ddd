// 기본 원시타입 래퍼
declare const customerId: unique symbol;
class CustomerId {
    [customerId]!: never;
    constructor(readonly value: number) {}
}

declare const string50: unique symbol;
class String50 {
    [string50]!: never;
    constructor(readonly value: string) {}
}

declare const emailAddress: unique symbol;
class EmailAddress {
    [emailAddress]!: never;
    constructor(readonly value: string) {
    }
}

declare const zipCode: unique symbol;
class ZipCode {
    [zipCode]!: never;
    constructor(readonly value: string) {
    }
}

declare const orderId: unique symbol;
class OrderId {
    [orderId]!: never;
    constructor(readonly value: string) {
    }
}

declare const orderLineId: unique symbol;
class OrderLineId {
    [orderLineId]!: never;
    constructor(readonly value: string) {
    }
}

declare const price: unique symbol;
class Price {
    [price]!: never;
    constructor(readonly value: number) {
    }
}

declare const billingAmount: unique symbol;
class BillingAmount {
    [billingAmount]!: never;
    constructor(readonly value: number) {}
}

// 상품 코드
declare const widgetCode: unique symbol;
class WidgetCode {
    [widgetCode]!: never;
    constructor(readonly value: string) {
        if (!/^W\\d{4}$/.test(value)) {
            throw new Error(`WidgetCode should be at least 4 digits and start with 'W'.`)
        }
    }
}

declare const gizmoCode: unique symbol;
class GizmoCode {
    [gizmoCode]!: never;
    constructor(readonly value: string) {}
}

type ProductCode = WidgetCode | GizmoCode;

// 주문 수량
declare const unitQuantity: unique symbol;
class UnitQuantity {
    [unitQuantity]!: never;
    private constructor(readonly value: number) {
        super();
    }
    static create(i: number): E.Either
}

declare const kilogramQuantity: unique symbol;
class KilogramQuantity {
    [kilogramQuantity]!: never;
    constructor(readonly value: number) {}
}
type OrderQuantity = UnitQuantity | KilogramQuantity;
