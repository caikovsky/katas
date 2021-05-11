import kotlin.math.roundToInt

private val invalidSeparatorSequenceRegex = Regex("(.*,\\n.*)|(.*\\n,.*)")
private val newLineSeparatorRegex = Regex("\n")

fun add(number: String): String {
    return when {
        number.matches(invalidSeparatorSequenceRegex) -> {
            val index = newLineSeparatorRegex.find(number)?.range?.first
            return "Number expected but '\\n' found at position $index."
        }

        number.endsWithDelimiter() -> "Number expected but EOF found."

        number.startsWithDelimiter() -> "Number expected but SOF found."

        else -> number.split(",", "\n").map { it.toFloatHandlingEmpty() }.sum().toFloor()
    }
}

private fun String.toFloatHandlingEmpty(): Float = if (isEmpty()) 0F else toFloat()
private fun Float.toFloor(): String = if (this % 1F != 0F) toString() else roundToInt().toString()
private fun String.startsWithDelimiter(): Boolean = first() == ',' || first() == '\n'
private fun String.endsWithDelimiter(): Boolean = last() == ',' || last() == '\n'
