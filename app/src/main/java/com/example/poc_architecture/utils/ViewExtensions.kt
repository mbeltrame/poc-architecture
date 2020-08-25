package com.example.poc_architecture.utils

import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.annotation.Px
import androidx.core.content.ContextCompat
import com.example.poc_architecture.R

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

fun TextView.setLeftDrawable(position: Int, iconId: String?, size: Int = R.dimen.highlight_view_drawable_width) {
    if (position == 0 && iconId != null) {
        val resourceId: Int = resources.getIdentifier(iconId, "drawable", context.packageName)
        if (resourceId != 0) {
            val drawable = ContextCompat.getDrawable(context, resourceId)
            val w = resources.getDimensionPixelOffset(size)
            val h = resources.getDimensionPixelOffset(size)
            drawable!!.setBounds(0, 0, w, h)
            this.setCompoundDrawables(drawable, null, null, null)
            this.compoundDrawablePadding = resources.getDimensionPixelOffset(R.dimen.highlight_view_padding_drawable)
        }
    }
}