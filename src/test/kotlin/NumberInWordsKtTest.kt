import org.junit.Test
import kotlin.test.assertEquals

class NumberInWordsKtTest {

    @Test
    fun `a single digit should return one to nine`() {
        expectedConversion()
        expectedConversion(expected = "one", number = 1)
        expectedConversion(expected = "two", number = 2)
        expectedConversion(expected = "three", number = 3)
        expectedConversion(expected = "four", number = 4)
        expectedConversion(expected = "five", number = 5)
        expectedConversion(expected = "six", number = 6)
        expectedConversion(expected = "seven", number = 7)
        expectedConversion(expected = "eight", number = 8)
        expectedConversion(expected = "nine", number = 9)
    }

    @Test
    fun `a two digit number should return ten to twenty`() {
        expectedConversion("ten", 10)
        expectedConversion(expected = "eleven", number = 11)
        expectedConversion(expected = "twelve", number = 12)
        expectedConversion(expected = "thirteen", number = 13)
        expectedConversion(expected = "fourteen", number = 14)
        expectedConversion(expected = "fifteen", number = 15)
        expectedConversion(expected = "sixteen", number = 16)
        expectedConversion(expected = "seventeen", number = 17)
        expectedConversion(expected = "eighteen", number = 18)
        expectedConversion(expected = "nineteen", number = 19)
        expectedConversion(expected = "twenty", number = 20)
    }

    @Test
    fun `should return arbitrary two digits`() {
        expectedConversion(expected = "twenty-one", number = 21)
        expectedConversion(expected = "twenty-nine", number = 29)
        expectedConversion(expected = "thirty", number = 30)
    }

    @Test
    fun `should convert tens to word`() {
        expectedConversion(expected = "twenty", number = 20)
        expectedConversion(expected = "thirty", number = 30)
        expectedConversion(expected = "forty", number = 40)
        expectedConversion(expected = "fifty", number = 50)
        expectedConversion(expected = "sixty", number = 60)
        expectedConversion(expected = "seventy", number = 70)
        expectedConversion(expected = "eighty", number = 80)
        expectedConversion(expected = "ninety", number = 90)
    }

    @Test
    fun `should convert 100 to one hundred`() {
        expectedConversion(expected = "one hundred", number = 100)
        expectedConversion(expected = "two hundred", number = 200)
        expectedConversion(expected = "three hundred", number = 300)
        expectedConversion(expected = "four hundred", number = 400)
        expectedConversion(expected = "five hundred", number = 500)
        expectedConversion(expected = "six hundred", number = 600)
        expectedConversion(expected = "seven hundred", number = 700)
        expectedConversion(expected = "eight hundred", number = 800)
        expectedConversion(expected = "nine hundred", number = 900)
    }

    @Test
    fun `should convert arbitrary hundreds`() {

    }

    private fun expectedConversion(expected: String = "zero", number: Int = 0) {
        assertEquals(expected, number.convertNumberIntoWords())
    }
}