//zadanie1
fun przeliczarka(a: Int){

    for(i in 1..a step 1){

        var k =""
        if(i % 3==0){
            k = k + "trzy"
        }
        if(i%5==0){
            k = k+"piec"
        }
        if(i%7==0){
            k = k+"siedem"
        }
        if(i%11==0){
            k = k+"jedenascie"
        }
        if(i%13==0){
            k = k+"trzynascie"
        }
        if(k==""){
            println(i)
        }
        else{
            println(k)
        }

    }


}
//zadanie 2
fun palindrom(a: String): Boolean{

    return a == a.reversed()

}
//zadanie3
fun paskalownik(a: Int): List<List<Int>> {
    val triangle = mutableListOf<List<Int>>()

    for (i in 0 until a) {
        val row = MutableList(i + 1) { 1 }

        for (j in 1 until i) {
            row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
        }

        triangle.add(row)
    }

    return triangle
}

fun paskalownika(a: Int) {
    val triangle = paskalownik(a)

    for (row in triangle) {
        val padding = " ".repeat((a - row.size) * 2)
        println(padding + row.joinToString(" "))
    }
}
//zadanie4
fun sumownik(n: Int): Int {
    var sum = 0
    for (i in 1 until n) {
        if (n % i == 0) {
            sum += i
        }
    }
    return sum
}

fun klasyfikowanie(n: Int): String {
    val sum = sumownik(n)

    return when {
        sum == n -> "perfect"
        sum > n -> "abundant"
        else -> "deficient"
    }
}
//zadanie5
fun armstrongarnia(n: Int): Boolean{
    val d = n.toString().length
    var ku = 0
    var zmienna = n
    while(zmienna>0){
        ku = ku + Math.pow(zmienna%10.toDouble(), d.toDouble()).toInt()
        zmienna = zmienna/10
    }
   return ku == n
}





fun main() {
    //zadanie1
przeliczarka(15015)
    //zadanie2
    val slowo = "abba"
    println(palindrom(slowo))
    //zadanie3
    val wielkosc = 4
    paskalownika(wielkosc)
    //zadanie4
    val n1 = 28
    val n2 = 12
    val n3 = 8
    println(klasyfikowanie(n1)) // perfect
    println(klasyfikowanie(n2)) // abundant
    println(klasyfikowanie(n3)) // deficient
    //zadanie5
    println(armstrongarnia(153))
}
