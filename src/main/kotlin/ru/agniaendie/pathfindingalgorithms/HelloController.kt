package ru.agniaendie.pathfindingalgorithms

import javafx.fxml.FXML
import javafx.scene.layout.VBox
import ru.agniaendie.pathfindingalgorithms.algorithm.astar.AStarTest
import ru.agniaendie.pathfindingalgorithms.graph.Edge
import ru.agniaendie.pathfindingalgorithms.graph.Node

class HelloController {

    @FXML
    lateinit var root: VBox

    @FXML
    private fun onHelloButtonClick() {
        test()
    }

    private fun test() {
        val aStarTest = AStarTest()
        aStarTest.prepareTest()
        aStarTest.getResult()

    }
}
