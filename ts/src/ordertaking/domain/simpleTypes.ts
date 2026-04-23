declare const customerId: unique symbol;
class CustomerId {
    [customerId]!: never;
    constructor(readonly value: number) {}
}

declare const widgetCode: unique symbol;
class WidgetCode {
    [widgetCode]!: never;
    constructor(readonly value: string) {}
}

declare const gizmoCode: unique symbol;
class GizmoCode {
    [gizmoCode]!: never;
    constructor(readonly value: string) {}
}

declare const unitQuantity: unique symbol;
class UnitQuantity {
    [unitQuantity]!: never;
    constructor(readonly value: number) {}
}

declare const kilogramQuantity: unique symbol;
class KilogramQuantity {
    [kilogramQuantity]!: never;
    constructor(readonly value: number) {}
}

type ProductCode = WidgetCode | GizmoCode;
type OrderQuantity = UnitQuantity | KilogramQuantity;
