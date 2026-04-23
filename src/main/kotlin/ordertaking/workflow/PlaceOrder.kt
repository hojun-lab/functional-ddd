package com.kalrap.ordertaking.workflow

import com.kalrap.ordertaking.domain.UnvalidatedOrder
import com.kalrap.ordertaking.domain.ValidatedOrder

typealias ValidateOrder = (UnvalidatedOrder) -> ValidatedOrder