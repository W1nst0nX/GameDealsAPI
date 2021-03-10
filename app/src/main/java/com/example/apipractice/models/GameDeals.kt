package com.example.apipractice.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameDeals(
        val internalName: String,
        val title: String,
        val metacriticLink: String,
        val dealID: String,
        val storeID: String,
        val gameID: Int,
        val salePrice: Double,
        val normalPrice: Double,
        val isOnSale: Boolean,
        val savings: Double,
        val metaCriticScore: Int,
        val steamRatingText: String,
        val steamRatingPercent: Int,
        val steamRatingCount: Int,
        val steamAppId: String,
        val releaseDate: Int,
        val lastChange: Int,
        val dealRating: Double,
        val thumb: String
) : Parcelable