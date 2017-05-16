enum class Digit(val value: String) {
    D1("1"),
    D2("2"),
    D3("3"),
    D4("4"),
    D5("5"),
    D6("6"),
    D7("7"),
    D8("8"),
    D9("9");

    override fun toString() = value

    companion object {
        fun fromValue(v: Int) = if (v >= 0 && v < values().size) values()[v - 1] else throw IllegalArgumentException("$v")
        fun fromValue(v: String) = values().find { it.value == v } ?: throw IllegalArgumentException(v)
    }
}
