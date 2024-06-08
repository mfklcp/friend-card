package com.mfkl.friendcard.menu.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.datetime.LocalDate

@Serializable
data class Transaction(
    @SerialName("bank") val bank: Bank,
    @SerialName("value") val value: String,
    @SerialName("purchaseDate") val purchaseDate: LocalDate,
    @SerialName("description") val description: String,
    @SerialName("buyer") val buyer: Buyer,
    @SerialName("installment") val installment: Installment,
)

@Serializable
data class Bank(
    @SerialName("name") val name: String,
    @SerialName("color") val color: Int,
)

@Serializable
data class Buyer(
    @SerialName("name") val name: String,
    @SerialName("phone") val phone: Int,
)

@Serializable
data class Installment(
    @SerialName("current") val current: Int,
    @SerialName("total") val total: Int,
)
