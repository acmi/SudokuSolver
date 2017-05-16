import java.io.Serializable

interface Cell<T> : Serializable {
    val x: Int
    val y: Int

    /** getter */
    operator fun invoke(): T

    /** setter */
    operator fun invoke(v: T)
}
