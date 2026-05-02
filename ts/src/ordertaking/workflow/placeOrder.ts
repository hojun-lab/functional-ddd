import {UnvalidatedOrder} from "../domain/unvalidatedOrder";
import {ValidatedOrder} from "../domain/validatedOrder";

type ValidateOrder = (i: UnvalidatedOrder) => ValidatedOrder;