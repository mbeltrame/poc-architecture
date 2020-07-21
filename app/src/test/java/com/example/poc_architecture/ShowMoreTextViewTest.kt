package com.example.poc_architecture

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.poc_architecture.utils.ShowMoreTextView
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.util.ReflectionHelpers

@RunWith(RobolectricTestRunner::class)
class ShowMoreTextViewTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun `test default values`() {

        val showMoreTextView = ShowMoreTextView(context, null)

        val text = ReflectionHelpers.getField<String>(showMoreTextView, "textShowMore")
        val threshold = ReflectionHelpers.getField<Int>(showMoreTextView, "thresholdActivation")
        val amountLines = ReflectionHelpers.getField<Int>(showMoreTextView, "amountLines")
        val colorClickableText =
            ReflectionHelpers.getField<Int>(showMoreTextView, "colorClickableText")

        assertNull(showMoreTextView.iCallbackShowMore)
        assertNull(showMoreTextView.position)
        assertEquals("Show more", text)
        assertEquals(5, threshold)
        assertEquals(2, amountLines)
        assertTrue(showMoreTextView.isExpanded)
        assertEquals(context.getColor(R.color.background_ads), colorClickableText)
    }

    @Test
    fun `test update view expanded`() {

        val showMoreTextView = ShowMoreTextView(context, null)
        showMoreTextView.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"

        showMoreTextView.updateView(false)

        assertFalse(showMoreTextView.isExpanded)

        showMoreTextView.updateView(true)

        assertTrue(showMoreTextView.isExpanded)
    }
}