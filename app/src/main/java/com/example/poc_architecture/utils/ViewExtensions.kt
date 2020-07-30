package com.example.poc_architecture.utils

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import androidx.annotation.Px
import androidx.core.content.ContextCompat
import com.example.poc_architecture.R

fun String.toSpannableString(context: Context, @Px size: Int? = null): SpannableString {
    val spannableString = SpannableString(this)

    size?.let { spannableString.setSpan(AbsoluteSizeSpan(it), 0, length, Spanned.SPAN_INCLUSIVE_INCLUSIVE) }

    val color = ContextCompat.getColor(context, R.color.colorPrimary)
    spannableString.setSpan(ForegroundColorSpan(color), 0, length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

    return spannableString
}