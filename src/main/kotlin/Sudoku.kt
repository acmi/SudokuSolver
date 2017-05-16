typealias SudokuCellValue = Set<Digit>
typealias SudokuField = Grid<SudokuCellValue>
typealias Subgrid = List<Cell<SudokuCellValue>>

private val startPoints = (0..2).map { y -> (0..2).map { x -> Pair(x * 3, y * 3) } }.flatMap { it }
private val vectors = (0..2).map { y -> (0..2).map { x -> Pair(x, y) } }.flatMap { it }

fun SudokuField.subgrids(): List<Subgrid> = startPoints.map { (x, y) -> vectors.map { (dx, dy) -> get(x + dx, y + dy) } }
operator fun List<Subgrid>.get(x: Int, y: Int) = this[x / 3 + y / 3 * 3]
