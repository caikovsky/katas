import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class NumberInWordsKtTest {
    @Test
    fun `3 - should be three`() {
        assertEquals("three", 3.convertNumberToWords())
    }

    @Test
    fun `0 - should be zero`() {
        assertEquals("zero", 0.convertNumberToWords())
    }

    @Test
    fun `should return 1 to 9 in words`() {
        expectedConversionWord(number = 1, expectedWord = "one")
        expectedConversionWord(number = 2, expectedWord = "two")
        expectedConversionWord(number = 3, expectedWord = "three")
        expectedConversionWord(number = 4, expectedWord = "four")
        expectedConversionWord(number = 5, expectedWord = "five")
        expectedConversionWord(number = 6, expectedWord = "six")
        expectedConversionWord(number = 7, expectedWord = "seven")
        expectedConversionWord(number = 8, expectedWord = "eight")
        expectedConversionWord(number = 9, expectedWord = "nine")
    }

    @Test
    fun `should return 10 to 19 numbers in words`() {
        expectedConversionWord(number = 10, expectedWord = "ten")
        expectedConversionWord(number = 11, expectedWord = "eleven")
        expectedConversionWord(number = 12, expectedWord = "twelve")
        expectedConversionWord(number = 13, expectedWord = "thirteen")
        expectedConversionWord(number = 14, expectedWord = "fourteen")
        expectedConversionWord(number = 15, expectedWord = "fifteen")
        expectedConversionWord(number = 16, expectedWord = "sixteen")
        expectedConversionWord(number = 17, expectedWord = "seventeen")
        expectedConversionWord(number = 18, expectedWord = "eighteen")
        expectedConversionWord(number = 19, expectedWord = "nineteen")
    }

    @Test
    fun `should return 10's multiples numbers in words`() {
        expectedConversionWord(number = 10, expectedWord = "ten")
        expectedConversionWord(number = 20, expectedWord = "twenty")
        expectedConversionWord(number = 30, expectedWord = "thirty")
        expectedConversionWord(number = 40, expectedWord = "forty")
        expectedConversionWord(number = 50, expectedWord = "fifty")
        expectedConversionWord(number = 60, expectedWord = "sixty")
        expectedConversionWord(number = 70, expectedWord = "seventy")
        expectedConversionWord(number = 80, expectedWord = "eighty")
        expectedConversionWord(number = 90, expectedWord = "ninety")
    }

    @Test
    fun `should convert arbitrary hundred numbers in words`() {
        expectedConversionWord(number = 101, expectedWord = "one hundred and one")
        expectedConversionWord(number = 221, expectedWord = "two hundred and twenty-one")
        expectedConversionWord(number = 999, expectedWord = "nine hundred and ninety-nine")
        expectedConversionWord(number = 315, expectedWord = "three hundred and fifteen")
    }

    @Test
    fun `should return 1 to 9 single digits words in numbers`() {
        expectedConversionNumber(word = "one", expectedNumber = 1)
        expectedConversionNumber(word = "two", expectedNumber = 2)
        expectedConversionNumber(word = "three", expectedNumber = 3)
        expectedConversionNumber(word = "four", expectedNumber = 4)
        expectedConversionNumber(word = "five", expectedNumber = 5)
        expectedConversionNumber(word = "six", expectedNumber = 6)
        expectedConversionNumber(word = "seven", expectedNumber = 7)
        expectedConversionNumber(word = "eight", expectedNumber = 8)
        expectedConversionNumber(word = "nine", expectedNumber = 9)
    }

    @Test
    fun `should return 10 to 19 words in numbers`() {
        expectedConversionNumber(word = "ten", expectedNumber = 10)
        expectedConversionNumber(word = "eleven", expectedNumber = 11)
        expectedConversionNumber(word = "twelve", expectedNumber = 12)
        expectedConversionNumber(word = "thirteen", expectedNumber = 13)
        expectedConversionNumber(word = "fourteen", expectedNumber = 14)
        expectedConversionNumber(word = "fifteen", expectedNumber = 15)
        expectedConversionNumber(word = "sixteen", expectedNumber = 16)
        expectedConversionNumber(word = "seventeen", expectedNumber = 17)
        expectedConversionNumber(word = "eighteen", expectedNumber = 18)
        expectedConversionNumber(word = "nineteen", expectedNumber = 19)
    }

    @Test
    fun `should return 10's multiples words in numbers`() {
        expectedConversionNumber(word = "ten", expectedNumber = 10)
        expectedConversionNumber(word = "twenty", expectedNumber = 20)
        expectedConversionNumber(word = "thirty", expectedNumber = 30)
        expectedConversionNumber(word = "forty", expectedNumber = 40)
        expectedConversionNumber(word = "fifty", expectedNumber = 50)
        expectedConversionNumber(word = "sixty", expectedNumber = 60)
        expectedConversionNumber(word = "seventy", expectedNumber = 70)
        expectedConversionNumber(word = "eighty", expectedNumber = 80)
        expectedConversionNumber(word = "ninety", expectedNumber = 90)
    }

    @Test
    fun `should convert arbitrary two digits to number`() {
        expectedConversionNumber(word = "twenty-one", expectedNumber = 21)
        expectedConversionNumber(word = "sixty-five", expectedNumber = 65)
        expectedConversionNumber(word = "ninety-nine", expectedNumber = 99)
    }

    @Test
    fun `should convert arbitrary three digits to number`() {
        expectedConversionNumber(word = "one hundred", expectedNumber = 100)
        expectedConversionNumber(word = "two hundred", expectedNumber = 200)
        expectedConversionNumber(word = "three hundred", expectedNumber = 300)
        expectedConversionNumber(word = "four hundred", expectedNumber = 400)
        expectedConversionNumber(word = "five hundred", expectedNumber = 500)
        expectedConversionNumber(word = "six hundred", expectedNumber = 600)
        expectedConversionNumber(word = "seven hundred", expectedNumber = 700)
        expectedConversionNumber(word = "eight hundred", expectedNumber = 800)
        expectedConversionNumber(word = "nine hundred", expectedNumber = 900)
    }

    @Test
    fun `should convert arbitrary 100s`() {
        expectedConversionNumber(word = "one hundred and two", expectedNumber = 102)
        expectedConversionNumber(word = "two hundred and three", expectedNumber = 203)
        expectedConversionNumber(word = "three hundred and four", expectedNumber = 304)
        expectedConversionNumber(word = "four hundred and ten", expectedNumber = 410)
        expectedConversionNumber(word = "five hundred and twenty-two", expectedNumber = 522)
        expectedConversionNumber(word = "five hundred and thirty-five", expectedNumber = 535)
        expectedConversionNumber(word = "six hundred and sixty-six", expectedNumber = 666)
        expectedConversionNumber(word = "nine hundred and sixty-nine", expectedNumber = 969)
    }

    private fun expectedConversionNumber(expectedNumber: Int, word: String) {
        assertEquals(expectedNumber, word.convertWordToNumber())
    }

    private fun expectedConversionWord(expectedWord: String, number: Int) {
        assertEquals(expectedWord, number.convertNumberToWords())
    }
}