package com.example.internshpexchange.models

import androidx.annotation.StringRes
import com.example.internshpexchange.R
import java.io.Serializable

enum class InternshipType(
    @StringRes val nameId: Int
) : Serializable {

    Current(
        R.string.current_tab_name
    ),
    Planned(
        R.string.planned_tab_name
    ),
    Finished(
        R.string.finished_tab_name
    )
}