import io.mockk.every
import io.mockk.mockk
import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

val allEmployeeTestList = listOf(
    Employee(name = "Max", age = 17),
    Employee(name = "Sepp", age = 18),
    Employee(name = "Nine", age = 15),
    Employee(name = "Mike", age = 51)
)

val noOver18EmployeeTestList = listOf(
    Employee(name = "Max", age = 17),
    Employee(name = "Sepp", age = 16)
)

class SortedListMatcher<T>(private val comparator: Comparator<T>) : TypeSafeMatcher<List<T>>() {
    private var expectedList: List<T>? = null

    override fun describeTo(description: Description?) {
        expectedList?.let {
            description?.appendText(it.toString())
        }
    }

    override fun matchesSafely(list: List<T>?): Boolean {
        expectedList = list?.sortedWith(comparator)

        return list?.asSequence()?.zipWithNext { a, b ->
            comparator.compare(a, b) < 0
        }?.all {
            it
        } ?: true
    }
}


internal class EmployeeReportTest {

    lateinit var employeeReport: EmployeeReport

    private val employeeRepository = mockk<EmployeeRepository>()

    @BeforeEach
    fun setUp() {
        employeeReport = EmployeeReport(employeeRepository)
        every {
            employeeReport.list()
        } returns allEmployeeTestList
    }

    @Test
    fun `should list employee older than 18 years`() {

        val employeeList = employeeReport.list()
        assertThat(
            employeeList,
            everyItem(hasProperty("age", greaterThanOrEqualTo(18)))
        )
    }

    @Test
    fun `should return empty list when all employees are under 18`() {
        every {
            employeeReport.list()
        } returns noOver18EmployeeTestList

        val employeeList = employeeReport.list()
        assertThat(employeeList, `is`(empty()))
    }


    @Test
    fun `should employee list be sorted by name`() {
        val employeeList = employeeReport.list()

        val comparator = compareBy<Employee> { it.name }

        assertThat(
            employeeList, `is`(
                SortedListMatcher(
                    comparator
                )
            )
        )

    }

    @Test
    fun `should return employee list with capitalized employee name`() {
        val employeeList = employeeReport.list()

        assertThat(
            employeeList,
            everyItem(hasProperty("name", matchesPattern("[A-Z]*")))
        )
    }
}