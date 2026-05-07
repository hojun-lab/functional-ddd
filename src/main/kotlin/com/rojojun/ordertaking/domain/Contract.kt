package com.rojojun.ordertaking.domain

import com.rojojun.ordertaking.common.EmailAddress
import com.rojojun.ordertaking.common.Entity

class Contract(
    val contractId: ContractId,
    val phoneNumber: PhoneNumber,
    val emailAddress: EmailAddress,
) : Entity<ContractId> {
    override val id: ContractId
        get() = contractId
}
