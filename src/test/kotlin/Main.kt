fun main(args: Array<String>) {
    SudokuFieldFactory(
            "7 21 84  " +
                    "1   5    " +
                    "      9  " +
                    "8   9  1 " +
                    "     1 6 " +
                    "4  8     " +
                    "   4 5  7" +
                    "  1  2   " +
                    "  6   53 "
    ).apply {
        while (nextStep()) {}
        println(this)
    }
}
