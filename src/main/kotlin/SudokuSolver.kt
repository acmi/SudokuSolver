import java.util.*

val findSingleAvailable: (List<Cell<Set<Digit>>>) -> Unit = { group ->
    Digit.values()
            .associate { it to group.filter { cell -> it in cell() } }
            .filter { it.value.size == 1 }
            .forEach { (digit, list) ->
                list[0](EnumSet.of(digit))
            }
}

fun SudokuField.nextStep(): Boolean {
    val state = hashCode()

    cells().filter { it().size == 1 }
            .forEach { cell ->
                val v = cell().iterator().next()
                rows()[cell.y].filter { it.x != cell.x && v in it() }.forEach { it(it() - v) }
                columns()[cell.x].filter { it.y != cell.y && v in it() }.forEach { it(it() - v) }
                subgrids()[cell.x, cell.y].filter { it.y != cell.y && it.x != cell.x && v in it() }.forEach { it(it() - v) }
            }

    rows().forEach(findSingleAvailable)
    columns().forEach(findSingleAvailable)
    subgrids().forEach(findSingleAvailable)

    return state != hashCode()
}
