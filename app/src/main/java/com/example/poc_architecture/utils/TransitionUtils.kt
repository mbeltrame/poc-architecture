package com.example.poc_architecture.utils

import android.os.Build
import android.transition.*
import android.view.ViewGroup

enum class TransitionType {
    CHANGE_BOUNDS,
    AUTO_TRANSITION,
    FADE,
    SLIDE,
    EXPLODE,
    DEFAULT
}

class TransitionUtils {

    companion object {
        fun showTransition(
            container: ViewGroup?,
            transitionType: TransitionType,
            durationInMillis: Long? = null
        ) {
            if (container == null) return
            val transition = createTransition(transitionType, durationInMillis)
            TransitionManager.beginDelayedTransition(container, transition)
        }

        private fun createTransition(type: TransitionType, durationInMillis: Long?): Transition {
            val transition = when (type) {
                TransitionType.CHANGE_BOUNDS -> ChangeBounds()
                TransitionType.FADE -> Fade()
                TransitionType.AUTO_TRANSITION -> AutoTransition()
                TransitionType.SLIDE -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Slide()
                } else {
                    AutoTransition()
                }
                TransitionType.EXPLODE -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode()
                } else {
                    AutoTransition()
                }
                TransitionType.DEFAULT -> AutoTransition()
            }
            if (durationInMillis != null) {
                transition.duration = durationInMillis
            }
            return transition
        }
    }
}