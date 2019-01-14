import factory.CaseA

open class DemoClass {

    private var vars: String? = null

    companion object {
        @JvmStatic
        fun testDemo() {

        }

        val str = "strDemo"
    }

    fun main(args: Array<String>) {
        DemoClass.testDemo()

        test()
    }

    fun test() {
        var KtClass = KtClass()
        KtClass.str

        var caseA = CaseA()
        caseA.hashCode()
        vars = "lateinit"
        val tempoHashCode = vars?.hashCode()?.toString()
        println(tempoHashCode)
    }

}