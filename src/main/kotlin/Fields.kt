typealias Row<T> = List<Cell<T>>
typealias Column<T> = List<Cell<T>>

fun <T> Grid<T>.cells(): List<Cell<T>> = (0..(width * height - 1)).map { get(it % width, it / width) }

fun <T> Grid<T>.rows(): List<Row<T>> = (0..(height - 1)).map { y -> (0..(width - 1)).map { x -> get(x, y) } }

fun <T> Grid<T>.columns(): List<Column<T>> = (0..(width - 1)).map { x -> (0..(height - 1)).map { y -> get(x, y) } }
