import {Undefined} from "../common/common";
import {Entity} from "../../libs/model-type";
import { OrderId } from "../type/types";

type CustomerInfo = Undefined;
type ShippingAddress = Undefined;
type BillingAddress = Undefined;
type OrderLine = Undefined;
type BillingAmount = Undefined;

class Order extends Entity<OrderId> {
    constructor(
        readonly customerInfo: CustomerInfo,
        readonly shippingAddress: ShippingAddress,
        readonly billingAddress: BillingAddress,
        readonly orderLines: OrderLine[],
        readonly amountToBill: BillingAmount
    ) {
        super()
    }
}
