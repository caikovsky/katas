import java.util.regex.Pattern
import kotlin.math.roundToInt

private val invalidSeparatorSequenceRegex = Regex("(.*,\\n.*)|(.*\\n,.*)")
private val newLineSeparatorRegex = Regex("\n")
private val onlyDigitsRegex = Regex("^[0-9]")
private const val customDelimiterPattern = "//(.*?)\\n"

fun add(number: String): String {
    return when {
        // TODO: refactor extension functions?
        number.isEmpty() -> {
            return number.toFloatHandlingEmpty().toFloor()
        }

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
                if (it.matches(onlyDigitsRegex)) {
                    it.toFloatHandlingEmpty()
                } else {
                    var index = 0
                    var wrongDelimiter = it.toCharArray().filter { char ->
                        !char.isDigit()
                    }.joinToString("")

                    if (wrongDelimiter.contains(delimiter, ignoreCase = true)) {
                        wrongDelimiter = wrongDelimiter.replace(delimiter, "")
                    }

                    for (i in str.indices) {
                        if (str[i] != delimiter.first() && !str[i].isDigit()) {
                            index = i
                            break
                        }
                    }

                    return "'${delimiter}' expected but '${wrongDelimiter}' found at position $index."
                }
            }.sum().toFloor()
        }

        else -> number.split(",", "\n").map { it.toFloatHandlingEmpty() }.sum().toFloor()
    }
}

private fun String.toFloatHandlingEmpty(): Float = if (isEmpty()) 0F else toFloat()
private fun Float.toFloor(): String = if (this % 1F != 0F) toString() else roundToInt().toString()
private fun String.startsWithDelimiter(): Boolean = first() == ',' || first() == '\n'
private fun String.endsWithDelimiter(): Boolean = last() == ',' || last() == '\n'

// FIXME: refactor replicated code
private fun String.isCustomDelimiter(): Boolean {
    val matcher = Pattern.compile(customDelimiterPattern).matcher(this)
    return matcher.find()
}

private fun String.extractDelimiter(): String {
    val matcher = Pattern.compile(customDelimiterPattern).matcher(this)
    matcher.find()
    return matcher.group(1)
}
