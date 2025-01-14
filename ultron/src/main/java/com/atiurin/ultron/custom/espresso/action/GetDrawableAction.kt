package com.atiurin.ultron.custom.espresso.action

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.test.espresso.*
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.core.espresso.UltronEspresso
import com.atiurin.ultron.core.espresso.UltronEspressoInteraction
import com.atiurin.ultron.core.espresso.UltronEspressoOperation
import org.hamcrest.Matcher
import java.util.concurrent.atomic.AtomicReference

class GetDrawableAction(private val drawableContainer: AtomicReference<Drawable>) : ViewAction {
    override fun getConstraints(): Matcher<View> =
        isAssignableFrom(ImageView::class.java)

    override fun getDescription(): String = "getting text from TextView"

    override fun perform(uiController: UiController, view: View) {
        drawableContainer.set((view as ImageView).drawable)
    }
}

fun <T> UltronEspressoInteraction<T>.getDrawable() : Drawable? {
    val timeout = timeoutMs ?: UltronConfig.Espresso.ACTION_TIMEOUT
    val drawableContainer = AtomicReference<Drawable>()
    UltronEspresso.executeAction(
        UltronEspressoOperation(
            operationBlock = getInteractionActionBlock(GetDrawableAction(drawableContainer)),
            name = "GetDrawable from TextView with '${getInteractionMatcher()}'",
            type = CustomEspressoActionType.GET_DRAWABLE,
            description = "${interaction!!::class.java.simpleName} action '${CustomEspressoActionType.GET_DRAWABLE}' of '${getInteractionMatcher()}' with root '${getInteractionRootMatcher()}' during $timeout ms",
            timeoutMs = timeout
        ),
        resultHandler = resultHandler
            ?: UltronConfig.Espresso.ViewActionConfig.resultHandler
    )
    return drawableContainer.get()
}

fun ViewInteraction.getDrawable() = UltronEspressoInteraction(this).getDrawable()
fun DataInteraction.getDrawable() = UltronEspressoInteraction(this).getDrawable()
fun Matcher<View>.getDrawable() = UltronEspressoInteraction(Espresso.onView(this)).getDrawable()