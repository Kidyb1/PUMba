
//zad1
//fun r(s: String, i: Int): String {
//    var a = ""
//    var j = 0
//    while (j < i) {
//        a += s
//        j++
//    }
//    return a
//}
//zad2
fun <T> List<T>.tail(): List<T>{
    return this.drop(1)
}
fun <T> List<T>.head(): List<T>{
    return this.take(1)
}
//zad3
fun <A> posortowane(lst: List<A>, order: (A, A) -> Boolean): Boolean {
    return lst.zipWithNext().all { (a, b) -> order(a, b) }
}
//zad4
fun <A> tailToHead(lst: List<A>): List<A> {
    if (lst.isEmpty()) {
        throw IllegalStateException("Empty list")
    }

    if (lst.size == 1) {
        return lst
    }

    return listOf(lst.last()) + lst.dropLast(1)
}
//zad5
fun <A> setHead(lst: List<A>, item: A): List<A> {
    // Sprawdzamy, czy lista nie jest pusta
    return if (lst.isNotEmpty()) {
        listOf(item) + lst.drop(1) // Tworzymy nową listę z nowym pierwszym elementem
    } else {
        lst // Zwracamy oryginalną listę, jeśli jest pusta
    }
}
//zad6
fun check(N: Int, lst: List<Int>): Int {
    for (i in N until lst.size) {
        val preambula = lst.subList(i - N, i)
        val target = lst[i]

        var found = false
        for (j in preambula.indices) {
            for (k in j + 1 until preambula.size) {
                if (preambula[j] + preambula[k] == target) {
                    found = true
                    break
                }
            }
            if (found) break
        }

        if (!found) return target
    }
    return -1
}

fun main() {

    //zad1
    println("zad1")
    //println(r("a",5))
    val r = {s: String, i: Int ->
        var a = ""
        var j = 0
        while (j < i) {
            a += s
            j++
        }
        println(a)
    }
    r("a",5);
    //zad2
    println("zad2")
    val a = listOf(2,1,"asdsa",2)
    println( a.head());
    println(a.tail());
    //zad3
    println("zad3")


        // Przykłady różnych porządków

        // Funkcja porównawcza dla rosnącego porządku
        val rosnaco: (Int, Int) -> Boolean = { a, b -> a <= b }

        // Funkcja porównawcza dla malejącego porządku
        val malejaco: (Int, Int) -> Boolean = { a, b -> a >= b }

        // Funkcja porównawcza dla parzystych przed nieparzystymi
        val papnpa: (Int, Int) -> Boolean = { a, b -> (a % 2 == 0) || (b % 2 != 0) }

        // Przykładowe listy do sprawdzenia
        val l1z3 = listOf(1, 2, 3, 4, 5)  // Lista rosnąca
        val l2z3 = listOf(5, 4, 3, 2, 1)  // Lista malejąca
        val l3z3 = listOf(2, 4, 6, 1, 3, 5)  // Lista z parzystymi przed nieparzystymi
        val l4z3 = listOf(1, 3, 2, 4, 5)  // Lista z błędnym porządkiem rosnącym
        val l5z3 = listOf(2, 3, 4, 6, 1, 5)  // Lista z błędnym porządkiem parzystych

        // Sprawdzanie
        println("Czy list1 jest posortowana rosnąco? ${posortowane(l1z3, rosnaco)}")
        println("Czy list2 jest posortowana malejąco? ${posortowane(l2z3, malejaco)}")
        println("Czy list3 jest posortowana (parzyste przed nieparzystymi)? ${posortowane(l3z3, papnpa)}")
        println("Czy list4 jest posortowana rosnąco? ${posortowane(l4z3, rosnaco)}")
        println("Czy list5 jest posortowana (parzyste przed nieparzystymi)? ${posortowane(l5z3, papnpa)}")

    //zad4
    println("zad4")
    val z1l4 = listOf(1, 2, 3)
    val z2l4 = listOf("a", "b", "c", "d")

    println(tailToHead(z1l4))
    println(tailToHead(z2l4))

    try {
        println(tailToHead(emptyList<Int>()))
    } catch (e: IllegalStateException) {
        println(e.message)
    }
    //zad5
    println("zad5")
    val z1l5 = listOf(1, 2, 3, 4)
    val z2l5 = listOf("a", "b", "c")

    println(setHead(z1l5, 10))
    println(setHead(z2l5, "z"))
    println(setHead(emptyList<Int>(), 5))
    //zad6
    println("zad6")
    println(check(2, listOf(1, 2, 3, 4, 5, 6)))
    println(check(3, listOf(1, 2, 3, 5, 7, 12, 30)))
    println(check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)))

}