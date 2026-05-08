package com.rojojun.ordertaking.domain

import com.rojojun.ordertaking.common.InvoiceId

sealed interface Invoice {
    class Unpaid(
        val invoiceId: InvoiceId,
    ) : Invoice

    class Paid(
        val invoiceId: InvoiceId,
    ) : Invoice
}
