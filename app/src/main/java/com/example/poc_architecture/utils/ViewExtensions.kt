package com.example.poc_architecture.utils

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
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

fun View.setShadow(@ColorRes shadowColor: Int, @DimenRes cornerRadius: Int, @DimenRes elevation: Int, shadowGravity: Int = Gravity.BOTTOM, @ColorRes backgroundColorResource: Int = 0) {
    val resource = context.resources
    val firstLayer = 0
    val ratioTopBottom = 3
    val defaultRatio = 2

    if (background == null && backgroundColorResource == 0) {
        throw RuntimeException("Pass backgroundColorResource or use setBackground")
    }

    if (background != null && background !is ColorDrawable) {
        throw RuntimeException("${background::class.java.name} " + "is not supported, set background as " + "ColorDrawable or pass background as a resource")
    }

    val cornerRadiusValue = resource.getDimension(cornerRadius)
    val elevationValue = resource.getDimension(elevation).toInt()
    val shadowColorValue = ContextCompat.getColor(context, shadowColor)

    val backgroundColor = if (backgroundColorResource != 0) {
        ContextCompat.getColor(context, backgroundColorResource)
    } else {
        (background as ColorDrawable).color
    }

    val outerRadius = FloatArray(8) { cornerRadiusValue }

    val directionOfY = when (shadowGravity) {
        Gravity.CENTER -> 0
        Gravity.TOP -> -1 * elevationValue / ratioTopBottom
        Gravity.BOTTOM -> elevationValue / ratioTopBottom
        else -> elevationValue / defaultRatio // Gravity.LEFT & Gravity.RIGHT
    }

    val directionOfX = when (shadowGravity) {
        Gravity.LEFT -> -1 * elevationValue / ratioTopBottom
        Gravity.RIGHT -> elevationValue / ratioTopBottom
        else -> 0
    }

    val shapeDrawable = ShapeDrawable()
    shapeDrawable.paint.color = backgroundColor
    shapeDrawable.paint.setShadowLayer(cornerRadiusValue / ratioTopBottom, directionOfX.toFloat(), directionOfY.toFloat(), shadowColorValue)
    shapeDrawable.shape = RoundRectShape(outerRadius, null, null)

    when (Build.VERSION.SDK_INT) {
        in Build.VERSION_CODES.BASE..Build.VERSION_CODES.O_MR1 -> setLayerType(View.LAYER_TYPE_SOFTWARE, shapeDrawable.paint)
    }

    val drawable = LayerDrawable(arrayOf(shapeDrawable))
    drawable.setLayerInset(firstLayer, elevationValue, elevationValue * defaultRatio, elevationValue, elevationValue * defaultRatio)

    background = drawable
}