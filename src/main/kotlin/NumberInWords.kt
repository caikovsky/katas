val numbersInWords = mapOf(
    0 to "zero",
    1 to "one",
    2 to "two",
    3 to "three",
    4 to "four",
    5 to "five",
    6 to "six",
    7 to "seven",
    8 to "eight",
    9 to "nine",
    10 to "ten",
    11 to "eleven",
    12 to "twelve",
    13 to "thirteen",
    14 to "fourteen",
    15 to "fifteen",
    16 to "sixteen",
    17 to "seventeen",
    18 to "eighteen",
    19 to "nineteen",
    20 to "twenty",
    30 to "thirty",
    40 to "forty",
    50 to "fifty",
    60 to "sixty",
    70 to "seventy",
    80 to "eighty",
    90 to "ninety"
)

fun Int.convertNumberIntoWords(): String {
    return convert(this)
}

fun convert(number: Int): String {
    if (numbersInWords.contains(number)) {
        return numbersInWords.getValue(number)
    }

    val numberofDigits = "$number".length

    if (numberofDigits == 2) return getAmountOfTwoDigits(number)

    return getAmountOfThreeDigits(number)
}

fun getAmountOfTwoDigits(number: Int): String {
    val remain = number % 10 // 1
    val decimals = number - remain // 20..90

    return if (remain != 0)
        "${convert(decimals)}-${convert(remain)}"
    else
        "Number not mapped"
}

fun getAmountOfThreeDigits(number: Int): String {
    val remain = number % 100 // 1
    val hundreds = (number - remain) / 100 // 100

    return if (remain == 0) {
        "${convert(hundreds)} hundred"
    } else {
        "${convert(hundreds)} hundred and ${convert(remain)}"
    }
}