package com.rojojun.ordertaking.workflow

import com.rojojun.ordertaking.domain.UnvalidatedOrder
import com.rojojun.ordertaking.domain.ValidatedOrder

typealias ValidateOrder = (UnvalidatedOrder) -> ValidatedOrder