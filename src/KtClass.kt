open class KtClass {


     var str: String? = null

    val ex: String by lazy {
        "lazy inited"
    }

    fun main(args: Array<String>) {
        DemoClass.testDemo()

        val strDemo = DemoClass.str

    }

    companion object {
        @JvmStatic
        fun test() {

        }
    }


}