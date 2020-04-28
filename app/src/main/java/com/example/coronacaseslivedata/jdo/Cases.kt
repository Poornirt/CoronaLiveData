package com.example.coronacaseslivedata.jdo

import com.google.gson.annotations.SerializedName

data class Cases(
    @SerializedName("Country") var mCountry:String,
    @SerializedName("TotalConfirmed") var mTotalAffected:String
)