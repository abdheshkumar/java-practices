import scala.annotation.tailrec

//Print path between any two nodes in a Binary Tree
object CityOnlineTest extends App {

  sealed trait BinaryTree
  case class Node(v: String, left: BinaryTree, right: BinaryTree)
      extends BinaryTree
  case object Empty extends BinaryTree
  val data = Node(
    "A",
    Node("B", Node("D", Empty, Empty), Node("E", Empty, Empty)),
    Node("C", Node("F", Empty, Empty), Node("G", Empty, Empty))
  )

  //println(path("D", "G", data)) //DBACG
  //println(path("D", "E", data)) //DBE
  //println(path("E", "D", data)) //EBD

  /**
    * Collect all elements which are coming in a way while finding a element.
    * It will discard all elements if the element is not found in tree.
    * @param value:String start node/element
    * @param binaryTree:BinaryTree
    * @param result: List[String]
    * @return
    */
  def getPath(value: String,
              binaryTree: BinaryTree,
              result: List[String]): List[String] = {
    binaryTree match {
      case Node(v, left, right) =>
        val r = v +: result
        if (v == value) r
        else {
          val leftTraverse = getPath(value, left, r) //Search into Left Binary Tree
          if (leftTraverse.nonEmpty) leftTraverse //Found in left tree
          else getPath(value, right, r) //Search into Right Binary Tree
        }
      case Empty =>
        List.empty //Discard already collected element. We reached here because node is not found.
    }
  }

  /**
    * Find position of first common element
    * @param leftPath
    * @param rightPath
    * @param position
    * @return
    */
  @tailrec
  def intersectPosition(leftPath: List[String],
                        rightPath: List[String],
                        position: Int): Int = {
    (leftPath, rightPath) match {
      case (Nil, _) => 0
      case (_, Nil) => 0
      case (h1 :: t1, h2 :: t2) =>
        if (h1 == h2) position + 1
        else intersectPosition(t1, t2, position + 1)

    }
  }

  /**
    * There are two cases we have to consider:
    * 1- If the two nodes are in different subtrees of root nodes
    * 2- If the nodes are in the same subtree
    * @param start
    * @param end
    * @param root
    */
  def path(start: String, end: String, root: BinaryTree) = {
    val leftPath = getPath(start, root, List.empty)
    val rightPath = getPath(end, root, List.empty)
    val position = intersectPosition(leftPath, rightPath, 0)

    (leftPath.take(position) ++ rightPath.take(position - 1).reverse).mkString
  }

  def ifNodeExists(root: BinaryTree, key: String): Boolean = {
    root match {
      case Empty => false
      case Node(v, left, right) =>
        if (v == key) true
        else ifNodeExists(left, key) || ifNodeExists(right, key)
    }
  }

  def ifSameSubTree(root: BinaryTree, node1: String, node2: String): Boolean = {
    root match {
      case Node(v, left, right) =>
        if (ifNodeExists(left, node1)
            && ifNodeExists(left, node2)) true
        else ifNodeExists(right, node1) && ifNodeExists(right, node2)
      case Empty => false
    }
  }
  println(ifSameSubTree(data, "D", "E"))
}
