package com.rojojun.ordertaking.domain

import com.rojojun.ordertaking.common.InvoiceId
import com.rojojun.ordertaking.common.InvoiceInfo

sealed interface Invoice {
    class Unpaid(
        val invoiceId: InvoiceId,
        val invoiceInfo: InvoiceInfo,
    ) : Invoice

    class Paid(
        val invoiceId: InvoiceId,
        val invoiceInfo: InvoiceInfo,
    ) : Invoice
}
