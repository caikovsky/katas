val numbersWithWords = mapOf(
    0 to "zero", 1 to "one", 2 to "two", 3 to "three", 4 to "four",
    5 to "five", 6 to "six", 7 to "seven", 8 to "eight", 9 to "nine",
    10 to "ten", 11 to "eleven", 12 to "twelve", 13 to "thirteen",
    14 to "fourteen", 15 to "fifteen", 16 to "sixteen", 17 to "seventeen",
    18 to "eighteen", 19 to "nineteen", 20 to "twenty", 30 to "thirty",
    40 to "forty", 50 to "fifty", 60 to "sixty", 70 to "seventy",
    80 to "eighty", 90 to "ninety"
)

val convertFunctions = mapOf<Int, (Int) -> String>(
    2 to {number -> get2DigitsText(number)},
    3 to {number -> get3DigitsText(number)}
)

fun Int.convertNumberToWords(): String {
    return convertNumbers(this)
}

fun String.convertWordToNumber(): Int {
    return numbersWithWords.filterValues { word -> this == word }.keys.first()
}

private fun convertNumbers(number: Int): String {
    if (numbersWithWords.contains(number)) {
        return numbersWithWords.getValue(number)
    }
    return convertFunctions["$number".length]?.invoke(number).toString()
}

private fun get2DigitsText(number: Int): String {
    val remain = number % 10
    val tens = number - remain
    return if (remain != 0) {
        "${convertNumbers(tens)}-${convertNumbers(remain)}"
    } else {
        "number not mapped."
    }
}

private fun get3DigitsText(number: Int): String {
    val remain = number % 100
    val hundredDigit = (number - remain) / 100
    return if (remain == 0) {
        "${convertNumbers(hundredDigit)} hundred"
    } else {
        "${convertNumbers(hundredDigit)} hundred and ${convertNumbers(remain)}"
    }
}