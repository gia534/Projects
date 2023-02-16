import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val ticTacToe = TicTacToe() // Creating an instance of the class tic-tac-toe


    println("Choose the mark you want to play with. X? or O?")
    var userInput = readln()
    while( (userInput.toCharArray()[0] != 'X') && (userInput.toCharArray()[0] != 'O')){
        println("Please pick between 'X' or 'O'")
        userInput = readln()
    }
    ticTacToe.playerChooseMark(userInput.toCharArray()[0])

    if (userInput.toCharArray()[0] == 'X'){
        ticTacToe.computerMark('O')
    }else{
        ticTacToe.computerMark('X')
    }

    var x = 0

    do {

        println("Choose a number between 1 and 9")
        userInput = readln()
        ticTacToe.userInput(userInput.toInt())

        ticTacToe.printBoard()


        if(ticTacToe.playerIsWinner()){
            ticTacToe.announceWinnerEndGame()
            exitProcess(0)
        } else {
            println("Computer's Turn")
        }

        ticTacToe.computerInput(ticTacToe.computerRandomMark())
        ticTacToe.printBoard()
        ticTacToe.announceWinnerEndGame()

   } while (!ticTacToe.playerIsWinner() && !ticTacToe.computerIsWinner())

}