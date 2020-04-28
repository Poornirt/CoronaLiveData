package com.example.coronacaseslivedata.jdo

import com.google.gson.annotations.SerializedName

@SuppressWarnings("unused")
data class CasesWrapper(
   @SerializedName("Countries")  var mCases:List<Cases>
)