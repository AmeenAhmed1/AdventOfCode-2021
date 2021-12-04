import java.io.File

fun readFile(name: String) = File("src/inputs", "$name.txt").readLines().map { it.toInt() }