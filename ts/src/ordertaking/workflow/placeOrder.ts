import {UnvalidatedOrder} from "../domain/unvalidatedOrder";
import {ValidatedOrder} from "../domain/ValidatedOrder";

type ValidateOrder = (i: UnvalidatedOrder) => ValidatedOrder;