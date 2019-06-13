package com.namjackson.archstudy.data.source.remote.upbit.response

import com.google.gson.annotations.SerializedName

data class UpbitMarket(
    @SerializedName("market") val market: String,
    @SerializedName("korean_name") val koreanName: String,
    @SerializedName("english_name") val englishName: String
)