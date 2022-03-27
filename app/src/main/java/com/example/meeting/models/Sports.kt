package com.example.meeting.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sports(@SerializedName("sports") var sports: List<Sport> = emptyList()) : Parcelable

@Parcelize
data class Sport(
    @SerializedName("idSport") var id: String?,
    @SerializedName("strSport") var name: String?,
    @SerializedName("strFormat") var format: String?,
    @SerializedName("strSportThumb") var thumb: String?,
    @SerializedName("strSportIconGreen") var iconGreen: String?,
    @SerializedName("strSportDescription") var description: String?
) : Parcelable