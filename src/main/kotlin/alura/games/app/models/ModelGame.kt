package alura.games.app.models

data class ModelGame(val info: InfoSharkApi){
    override fun toString(): String {
        return info.toString()
    }
}
