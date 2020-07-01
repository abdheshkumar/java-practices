object Task1 {
  def main(args: Array[String]): Unit = {
    val s = "we test coders. Give us a try?"
    val s1 = "Forget CVs..Save time . x x"
    println(solution(s))
    println(solution(s1))
  }
  def solution(S: String): Int = {
    val separators = Array('.', '?', '!')
    S.split(separators)
      .map(_.split(" ").filterNot(_.isEmpty).length)
      .max
  }

}
