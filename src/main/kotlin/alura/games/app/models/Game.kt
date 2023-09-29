package alura.games.app.models

data class Game(val title: String,
                val thumb: String) {
    private var description: String? = null

    override fun toString(): String {
        return """
            title: $title
            thumb: $thumb
            description: ${this.description}
        """.trimIndent()
    }
}
