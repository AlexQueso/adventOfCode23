package twentyThree.day07

const val FIVE_OF_A_KIND = 6
const val FOUR_OF_A_KIND = 5
const val FULL_HOUSE = 4
const val THREE_OF_A_KIND = 3
const val TWO_PAIR = 2
const val ONE_PAIR = 1
const val HIGH_CARD = 0

class Cards (private val cardsLine: String) {

    val cardList: List<Int> = getCardIntList()
    private val cardMap = getCardMap()
    val handType = calculateHandType()
    private fun getCardIntList(): List<Int> {
        val list = mutableListOf<Int>()
        cardsLine
            .chunked(1)
            .forEach { card->
                list.add(translateCardsIntoValues(card))
            }
        return list
    }

    private fun translateCardsIntoValues(input: String) = when (input){
        "T" -> 10
        "J" -> 1
        "Q" -> 12
        "K" -> 13
        "A" -> 14
        else -> input.toInt()
    }

    private fun calculateHandType(): Int{
        return if (isFiveOfAKind()){
            FIVE_OF_A_KIND
        } else if (isFourOfAKind()) {
            FOUR_OF_A_KIND
        } else if (isFullHouse()) {
            FULL_HOUSE
        } else if (isThreeOfAKind()) {
            THREE_OF_A_KIND
        } else if (isTwoPairs()){
            TWO_PAIR
        } else if (isOnePair()){
            ONE_PAIR
        } else {
            HIGH_CARD
        }
    }

    private fun isFullHouse(): Boolean {
        return isOnePair() && isThreeOfAKind()
    }

    private fun isFiveOfAKind() : Boolean {
        cardMap.forEach{
            if (it.value == 5){
                return true
            }
        }
        return false
    }

    private fun isFourOfAKind(): Boolean {
        cardMap.forEach{
            if (it.value == 4){
                return true
            }
        }
        return false
    }

    private fun isThreeOfAKind(): Boolean {
        cardMap.forEach{
            if (it.value == 3){
                return true
            }
        }
        return false
    }

    private fun isOnePair(): Boolean {
        cardMap.forEach{
            if (it.value == 2){
                return true
            }
        }
        return false
    }

    private fun isTwoPairs(): Boolean {
        var onePair = false
        cardMap.forEach{
            if (it.value == 2 && !onePair) {
                onePair = true
            } else if (it.value == 2 && onePair) {
                return true
            }
        }
        return false
    }

    private fun getCardMap(): Map<Int, Int> {
        val map = mutableMapOf<Int, Int>()
        cardList.forEach {
            if (map.containsKey(it)){
                val amount = map[it]!!
                map.replace(it, amount+1)
            } else {
                map[it] = 1
            }
        }
        updateMapWithJokers(map)
        return map
    }

    private fun updateMapWithJokers(map: MutableMap<Int, Int>) {
        val amountOfJokers = map[1] ?: 0
        if (amountOfJokers in 1..4) {
            map.remove(1)
            val highestAmount = getHighestAmount(map)
            map.forEach {
                if (it.value == highestAmount){
                    map.replace(it.key, it.value + amountOfJokers)
                    return
                }
            }
        }
    }

    private fun getHighestAmount(map: MutableMap<Int, Int>) : Int {
        var amount = 1
        map.values.forEach {
            if (it>amount){
                amount = it
            }
        }
        return amount
    }

}