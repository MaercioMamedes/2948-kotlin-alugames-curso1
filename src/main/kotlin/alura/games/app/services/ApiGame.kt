package alura.games.app.services

import alura.games.app.models.ModelGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse


object ApiGame {

    private const val URL_BASE: String = "https://www.cheapshark.com/api/1.0/games?id="
    private val client: HttpClient = HttpClient.newHttpClient()

    fun getGame(id: String): ModelGame {
            val request = HttpRequest.newBuilder()
                .uri(URI.create(this.URL_BASE+id))
                .build()

            val response = this.client
                .send(request, HttpResponse.BodyHandlers.ofString())

            val data = response.body()
            println(data)

            val gson =Gson()
            val infoGame = gson.fromJson(data, ModelGame::class.java)

            return infoGame
    }

}
