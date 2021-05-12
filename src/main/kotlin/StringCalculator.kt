import java.util.regex.Pattern
import kotlin.math.roundToInt

private val invalidSeparatorSequenceRegex = Regex("(.*,\\n.*)|(.*\\n,.*)")
private val newLineSeparatorRegex = Regex("\n")
private val customDelimiterWrapperRegex = Regex("[/\n]")
private const val customDelimiterPattern = "//(.*?)\\n"

fun add(number: String): String {
    return when {
        number.matches(invalidSeparatorSequenceRegex) -> {
            val index = newLineSeparatorRegex.find(number)?.range?.first
            return "Number expected but '\\n' found at position $index."
        }

        number.endsWithDelimiter() -> "Number expected but EOF found."

        number.startsWithDelimiter() -> "Number expected but SOF found."

        number.isCustomDelimiter() -> {
            val delimiter = number.extractDelimiter()
            val str = number.substringAfter("\n")

            str.split(delimiter).map {
                it.toFloatHandlingEmpty()
            }.sum().toFloor()
        }

        else -> number.split(",", "\n").map { it.toFloatHandlingEmpty() }.sum().toFloor()
    }
}

private fun String.toFloatHandlingEmpty(): Float = if (isEmpty()) 0F else toFloat()
private fun Float.toFloor(): String = if (this % 1F != 0F) toString() else roundToInt().toString()
private fun String.startsWithDelimiter(): Boolean = first() == ',' || first() == '\n'
private fun String.endsWithDelimiter(): Boolean = last() == ',' || last() == '\n'
private fun String.isCustomDelimiter(): Boolean = contains(customDelimiterWrapperRegex)
private fun String.extractDelimiter(): String {
    val matcher = Pattern.compile(customDelimiterPattern).matcher(this)
    matcher.find()
    return matcher.group(1)
}