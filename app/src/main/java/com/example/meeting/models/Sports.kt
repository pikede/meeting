package com.example.meeting.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sports(@SerializedName("sports") var sports: List<Sport> = emptyList()) : Parcelable

@Parcelize
data class Sport(
    @SerializedName("idSport") var idSport: String?,
    @SerializedName("strSport") var strSport: String?,
    @SerializedName("strFormat") var strFormat: String?,
    @SerializedName("strSportThumb") var strSportThumb: String?,
    @SerializedName("strSportIconGreen") var strSportIconGreen: String?,
    @SerializedName("strSportDescription") var strSportDescription: String?
) : Parcelable