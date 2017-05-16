import java.util.*

object SudokuFieldFactory {
    /** empty field */
    operator fun invoke(): SudokuField =
            ArrayGrid<SudokuCellValue>(9, 9, { _, _ -> java.util.EnumSet.allOf(Digit::class.java) }).wrap()

    /** from string */
    operator fun invoke(s: String) = invoke().apply {
        val cells = cells()
        s.forEachIndexed { index, c ->
            cells[index](if (c == ' ') EnumSet.allOf(Digit::class.java) else EnumSet.of(Digit.fromValue(c.toString())))
        }
    }
}

fun Grid<Set<Digit>>.wrap() = object : SudokuField by this {
    override fun toString(): String {
        return StringBuilder().apply {
            (0..8).forEach { y ->
                (0..8).forEach { x ->
                    val digits = this@wrap[x, y]()
                    append(when (digits.size) {
                        0 -> " "
                        1 -> digits.iterator().next()
                        else -> "?"
                    })
                    if (x == 2 || x == 5)
                        append("|")
                }
                if (y != 8)
                    appendln()
                if (y == 2 || y == 5)
                    appendln("---+---+---")
            }
        }.toString()
    }

    override fun hashCode() = this@wrap.hashCode()

    override fun equals(other: Any?) = this@wrap == other
}
