package com.rojojun.ordertaking.common

sealed class ErrPrimitiveConstraints {
    data class ErrNumberLessThanMin(val min: Number) : ErrPrimitiveConstraints()
    data class ErrNumberGreaterThanMax(val max: Number) : ErrPrimitiveConstraints()
}
