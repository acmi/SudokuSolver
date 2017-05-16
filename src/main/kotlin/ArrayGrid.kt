class ArrayGrid<T>(override val width: Int,
                   override val height: Int,
                   initializer: (x: Int, y: Int) -> T) : Grid<T> {

    private val data = ArrayList((0..(width * height - 1)).map { initializer(it % width, it / width) })

    override operator fun get(x: Int, y: Int) = object : Cell<T> {
        override val x: Int
            get() = x
        override val y: Int
            get() = y

        override fun invoke(): T {
            return data[x + y * width]
        }

        override fun invoke(v: T) {
            data[x + y * width] = v
        }

        override fun toString() = "Cell[$x,$y]=${invoke()}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ArrayGrid<*>) return false

        if (width != other.width) return false
        if (height != other.height) return false
        if (data != other.data) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width
        result = 31 * result + height
        result = 31 * result + data.hashCode()
        return result
    }
}
