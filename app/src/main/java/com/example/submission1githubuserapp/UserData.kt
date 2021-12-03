package com.example.submission1githubuserapp

import android.os.Parcelable
import android.telephony.cdma.CdmaCellLocation
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData (
        var avatar: Int,
        var username: String,
        var name: String,
        var company: String,
        var location: String,
        var repository: String,
        var followers: String,
        var following: String
) : Parcelable