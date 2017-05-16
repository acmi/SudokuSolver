import java.io.Serializable

interface Grid<T> : Serializable {
    val width: Int
    val height: Int
    operator fun get(x: Int, y: Int): Cell<T>
}
