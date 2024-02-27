enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} se matriculou na ${this.nome}.")
    }

    fun listarConteudos() {
        println("A formação ${this.nome} possui os seguintes conteúdos:")
        for (conteudo in conteudos) {
            println("- ${conteudo.nome} (${conteudo.nivel}, ${conteudo.duracao} minutos)")
        }
    }
}

fun main() {
    val maria = Usuario("Maria", "maria@gmail.com")
    val joao = Usuario("João", "joao@gmail.com")
    val lucas = Usuario("Lucas", "lucas@gmail.com")

    val kotlinBasico = ConteudoEducacional("KOTLIN", Nivel.BASICO)
    val kotlinIntermediario = ConteudoEducacional("KOTLIN", Nivel.INTERMEDIARIO)
    val kotlinAvancado = ConteudoEducacional("KOTLIN", Nivel.AVANCADO)

    val formacaoKotlin = Formacao("Formação Kotlin", listOf(kotlinBasico, kotlinIntermediario, kotlinAvancado))

    
    formacaoKotlin.matricular(maria)
    formacaoKotlin.matricular(joao)
    formacaoKotlin.listarConteudos()
}
