package com.example.internshpexchange.models

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.example.internshpexchange.R

data class InternshipResponse(
    val status: ResponseStatus,
    val internship: Internship
)

enum class ResponseStatus(@StringRes val titleRes: Int, @ColorRes val colorRes: Int) {
    Refused(
        titleRes = R.string.refused,
        colorRes = R.color.refuded
    ),
    Accepted(
        titleRes = R.string.accepted,
        colorRes = R.color.accepted
    ),
    Considered(
        titleRes = R.string.considered,
        colorRes = R.color.considered
    )
}