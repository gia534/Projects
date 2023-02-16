import kotlin.system.exitProcess

class TicTacToe {
    private val board: Array<CharArray> = Array(3) { CharArray(3)}
    private var playerMark = ' '
    private var computerMark = ' '
    private val randomNumberList = mutableListOf(1,2,3,4,5,6,7,8,9)

    init {
        playerMark
        computerMark
        randomNumberList
        initBoard()

    }

    private fun initBoard(){
        for(i in 0..2){
            for(j in 0..2){
                board[i][j] = '_'
            }
        }
    }
    fun printBoard(): Unit{
        for (i in 0..2){
            for (j in 0..2){
                print("${board[i][j]} ")
            }
            println("")
        }
    }

    fun computerRandomMark(): Int {

        randomNumberList.shuffle()
        var listItem = 0
        for (i in 1 until randomNumberList.size){
            listItem = randomNumberList[i]
        }

        return listItem

    }
    private fun removeFromList(a: Int){
        randomNumberList.remove(a)

    }

    fun playerChooseMark (markOne: Char){
        playerMark = markOne
    }
    private fun addPlayerMark(row: Int, column: Int){
        board[row][column] = playerMark

    }
    fun computerMark (markOne: Char){
        computerMark = markOne
    }
    private fun addComputerMark(row: Int, column: Int){
        board[row][column] = computerMark
    }
    fun userInput(a: Int){

        when(a){
            1 ->{
                addPlayerMark(0, 0)
                removeFromList(1)

            }
            2 -> {
                addPlayerMark(0, 1)
                removeFromList(2)
            }
            3 -> {
                addPlayerMark(0,2)
                removeFromList(3)
            }
            4 -> {
                addPlayerMark(1,0)
                removeFromList(4)
            }
            5 -> {
                addPlayerMark(1,1)
                removeFromList(5)
            }
            6 -> {
                addPlayerMark(1,2)
                removeFromList(6)
            }
            7 -> {
                addPlayerMark(2,0)
                removeFromList(7)
            }
            8 -> {
                addPlayerMark(2,1)
                removeFromList(8)
            }

            9 -> {
                addPlayerMark(2,2)
                removeFromList(9)
            }

        }
    }

    fun computerInput(a: Int){
        when(a){
            1 -> {
                addComputerMark(0,0)
                removeFromList(1)
            }

            2 -> {
                addComputerMark(0,1)
                removeFromList(2)
            }

            3 -> {
                addComputerMark(0,2)
                removeFromList(3)
            }

            4 -> {
                addComputerMark(1,0)
                removeFromList(4)
            }

            5 -> {
                addComputerMark(1,1)
                removeFromList(5)
            }

            6 -> {
                addComputerMark(1,2)
                removeFromList(6)
            }

            7 -> {
                addComputerMark(2,0)
                removeFromList(7)
            }

            8 -> {
                addComputerMark(2,1)
                removeFromList(8)
            }

            9 -> {
                addComputerMark(2,2)
                removeFromList(9)
            }

        }
    }
    private fun isWinner(): String{
        var a = ""
       if(playerIsWinner()){
          a =  "You won!"
        } else if(computerIsWinner()) {
           a = "Computer won!"
        }


        return a

    }

    fun playerIsWinner(): Boolean {
        var playerWinner = false

        if ((board[0][2] == playerMark  && board[1][1] == playerMark && board[2][0] == playerMark) ||
            (board[0][0] == playerMark  && board[1][1] == playerMark && board[2][2] == playerMark) ||
            (board[0][0] == playerMark  && board[0][1] == playerMark && board[0][2] == playerMark) ||
            (board[1][0] == playerMark  && board[1][1] == playerMark && board[1][2] == playerMark) ||
            (board[2][0] == playerMark  && board[2][1] == playerMark && board[2][2] == playerMark) ||
            (board[0][0] == playerMark  && board[1][0] == playerMark && board[2][0] == playerMark) ||
            (board[0][1] == playerMark  && board[1][1] == playerMark && board[2][1] == playerMark) ||
            (board[0][2] == playerMark  && board[1][2] == playerMark && board[2][2] == playerMark)){
            playerWinner = true
        }
        return playerWinner
    }
    fun computerIsWinner(): Boolean {
        var comp = false
        if ((board[0][2] == computerMark  && board[1][1] == computerMark && board[2][0] == computerMark) ||
            (board[0][0] == computerMark  && board[1][1] == computerMark && board[2][2] == computerMark) ||
            (board[0][0] == computerMark  && board[0][1] == computerMark && board[0][2] == computerMark) ||
            (board[1][0] == computerMark  && board[1][1] == computerMark && board[1][2] == computerMark) ||
            (board[2][0] == computerMark  && board[2][1] == computerMark && board[2][2] == computerMark) ||
            (board[0][0] == computerMark  && board[1][0] == computerMark && board[2][0] == computerMark) ||
            (board[0][1] == computerMark  && board[1][1] == computerMark && board[2][1] == computerMark) ||
            (board[0][2] == computerMark  && board[1][2] == computerMark && board[2][2] == computerMark)){
           comp = true
        }
        return comp
    }

    private fun isBoardFilled(): Boolean{
        var filled = false
        if (board[0][0] != '_' && board[0][1] != '_' && board[0][2] != '_' &&
            board[1][0] != '_' && board[1][1] != '_' && board[1][2] != '_' &&
            board[2][0] != '_' && board[2][1] != '_' && board[2][2] != '_'){
            filled = true

        }
        return filled
    }

    fun announceWinnerEndGame(){
        if( playerIsWinner() || computerIsWinner()){
            println(isWinner())
            exitProcess(0)
        } else if(!playerIsWinner() && !computerIsWinner() && isBoardFilled()) {
            println("Tie")
            exitProcess(0)
        }

    }
}

