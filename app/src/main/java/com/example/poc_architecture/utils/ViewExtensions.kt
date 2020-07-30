package com.example.poc_architecture.utils

import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import androidx.annotation.Px

fun String.toSpannableString(color: Int? = null, @Px size: Int? = null): SpannableString {
    val spannableString = SpannableString(this)

    size?.let {
        spannableString.setSpan(AbsoluteSizeSpan(it), 0, length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
    }
    color?.let {
        spannableString.setSpan(ForegroundColorSpan(color), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    return spannableString
}