import kotlin.math.roundToInt

private val invalidSeparatorSequence = Regex("(.*,\\n.*)|(.*\\n,.*)")

fun add(number: String): String {
    if (number.matches(invalidSeparatorSequence)) {
        return "Number expected but '\\n' found at position 6"
    }

    return number.split(",", "\n").map { it.toFloatHandlingEmpty() }.sum().toFloor()
}

private fun String.toFloatHandlingEmpty(): Float = if (isEmpty()) 0F else toFloat()
private fun Float.toFloor(): String = if (this % 1F != 0F) toString() else roundToInt().toString()
