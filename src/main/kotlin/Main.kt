data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    val result= ArrayList<ItemData>()
    inputList?.let {
        for(item in inputList){
                val itemData: ItemData = when(item){
                    is Int -> ItemData(inputList.indexOf(item), item,"entero", if(item%10 == 0){ "M10"} else if(item%5==0){ "M5" } else if(item %2==0){ "M2" } else { null})
                    is Boolean ->ItemData(inputList.indexOf(item),item, "booleano", if(item != false) "verdadero" else "falso" )
                    is String ->  ItemData(inputList.indexOf(item), item, "cadena", "L"+item.length)
                    else -> ItemData(inputList.indexOf(item), item?: "po") }
                item?.let{result.add(itemData)}
        }
        return result
    }?: return null}