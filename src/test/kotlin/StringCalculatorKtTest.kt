import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

internal class StringCalculatorKtTest {

    @Test
    fun `return 0 when number is empty`() {
        assertEquals("0", add(""))
    }

    @Test
    fun `return number parameter if number is a single integer`() {
        assertEquals("1", add("1"))
        assertEquals("2", add("2"))
    }

    @Test
    fun `return number parameter if number is a single digit with decimal`() {
        assertEquals("1", add("1.0"))
        assertEquals("12.21", add("12.21"))
    }

    @Test
    fun `return the sum of two integers if numbers are delimited by comma`() {
        assertEquals("3", add("1,2"))
        assertEquals("6", add("3,3"))
        assertEquals("100", add("50,50"))
    }

    @Test
    fun `return the sum of three or more integers if numbers are delimited by comma`() {
        assertEquals("10", add("5,4,1"))
        assertEquals("10", add("5,4,1,0"))
        assertEquals("110", add("5,4,1,0,100"))
    }

    @Test
    fun `return the sum of two decimals if numbers are delimited by comma`() {
        assertEquals("9", add("5.0,4.0"))
        assertEquals("10.1", add("5.0,5.1"))
        assertEquals("5", add("5.0,0.0"))
    }

    @Test
    fun `return the sum of three or more decimals if numbers are delimited by comma`() {
        assertEquals("10.1", add("5.0,4.0,1.0,0.1"))
        assertEquals("10.1", add("5.0,4.0,1.0,0.1,0.0"))
    }

    @Test
    fun `return the sum of three or more integer and decimals if numbers are delimited by comma`() {
        assertEquals("6.5", add("1,2,3.5"))
        assertEquals("160.1", add("5.0,4.0,1.0,0.1,0.0,100,50"))
    }

    @Test
    fun `return the sum of two numbers if numbers are delimited by comma or has a line break`() {
        assertEquals("6", add("1\n2,3"))
        assertEquals("7", add("1\n2,3,0.1\n0.9"))
    }

    @Test
    fun `return the new line error when the line break is after or before a comma`() {
        assertEquals("Number expected but '\\n' found at position 6", add("1,\n2,3"))
        assertEquals("Number expected but '\\n' found at position 6", add("1,2\n,3"))
    }

    @Test
    fun `return the new line error when the line break is after and before a comma`() {
        assertEquals("Number expected but '\\n' found at position 6", add("1,\n2,3,0.1\n,0.9"))
    }

    @Test
    @Ignore
    fun `return malformed decimal number error if number has a missing decimal value`() {
        assertEquals("error!", add("10."))
    }
}