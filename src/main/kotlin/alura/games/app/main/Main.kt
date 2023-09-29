package alura.games.app.main

import alura.games.app.models.Game
import alura.games.app.services.ApiGame
import java.util.Scanner


fun main() {

    val scanner: Scanner = Scanner(System.`in`)
    print("Digite o ID do jogo: ")
    val idGame = scanner.nextLine()

    val dataGame = ApiGame.getGame(idGame)
    var game: Game? = null
    val responseApi = runCatching {
        game = Game(
            dataGame.info.title,
            dataGame.info.thumb
        )
    }

    responseApi.onFailure {
        println("Jogo inexistente, digite outro ID")
    }

    responseApi.onSuccess {
        println(game)
    }

}
