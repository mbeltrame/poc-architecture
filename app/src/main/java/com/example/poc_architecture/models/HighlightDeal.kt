package com.example.poc_architecture.models

import java.io.Serializable

class HighlightDeal(
    var label: Label?,
    var iconId: String? = null,
    var type: String?
) : Serializable