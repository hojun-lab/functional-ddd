export class UnvalidatedOrder {
    constructor(
        readonly orderId: string,
        readonly customInfo: UnvalidatedCustomInfo,
        readonly shippingAddress: UnvalidatedAddress
    ) {}
}

class UnvalidatedCustomInfo {
    constructor(
        readonly firstName: string,
        readonly lastName: string,
        readonly emailAddress: string
    ) {
    }
}

class UnvalidatedAddress {
    constructor(
        readonly addressLine1: string,
        readonly addressLine2: string,
        readonly addressLine3: string,
        readonly addressLine4: string,
        readonly city: string,
        readonly zipCode: string
    ) {
    }
}