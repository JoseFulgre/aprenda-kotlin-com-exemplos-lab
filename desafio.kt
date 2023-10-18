enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val formacao: Formacao)

data class ConteudoEducacional(var nome: String, val duracao: Int)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {


    private fun nivelamento(nivel: Nivel): String {
        return when (nivel) {
            Nivel.BASICO -> "Básico"
            Nivel.INTERMEDIARIO -> "Intermediário"
            Nivel.DIFICIL -> "Difícil"
        }
    }

    override fun toString(): String {
        return "Formação: $nome, Nível: ${nivelamento(nivel)}, Conteúdo: ${
            conteudos.joinToString{"${it.nome} Duração: ${it.duracao}"}}"
    }
}

val inscritos = mutableListOf<Usuario>()
fun imprimirInscritos(){
    inscritos.forEach{ i-> println("Aluno: ${i.nome} ${i.formacao} \n") }
}
fun matricular(usuario: Usuario) {

    inscritos.add(usuario)

}

fun main() {
    val formacao1 = Formacao(
        nome = "Formação Java", nivel = Nivel.BASICO, conteudos = listOf(
            ConteudoEducacional(nome = "Linguagem Java", duracao = 20),
            ConteudoEducacional(nome = "Programação Orientada a Objetos", duracao = 20)
        )
    )

    val formacao2 = Formacao(
        nome = "Formação Python", nivel = Nivel.INTERMEDIARIO, conteudos = listOf(
            ConteudoEducacional(nome = "Linguagem Python", duracao = 20),
            ConteudoEducacional(nome = "Programação Funcional", duracao = 20)
        )
    )

    matricular(Usuario("José", formacao1))
    matricular(Usuario("Maria", formacao2))
    matricular(Usuario("Pedro", formacao2))

    imprimirInscritos()
}