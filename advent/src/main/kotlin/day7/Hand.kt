package day7

const val FIVE_OF_A_KIND = 6
const val FOUR_OF_A_KIND = 5
const val FULL_HOUSE = 4
const val THREE_OF_A_KIND = 3
const val TWO_PAIR = 2
const val ONE_PAIR = 1
const val HIGH_CARD = 0

class Hand (private val hand: String, val bid: Int) : Comparable<Hand> {

    private val cards = Cards(hand)

    override fun compareTo(other: Hand): Int {
        if (hand == other.hand){
            return 0
        }
        if (compareHandType(other) != 0){
            return compareHandType(other)
        }
        return compareCardsOneByOne(other)
    }

    private fun compareCardsOneByOne(other: Hand): Int {
        for (index in 0 until 5) {
            if (cards.cardList[index] < other.cards.cardList[index]){
                return -1
            } else if (cards.cardList[index] > other.cards.cardList[index]) {
                return 1
            }
        }
        return 0
    }

    private fun compareHandType (other: Hand): Int{
        if (cards.handType != other.cards.handType){
            return if (cards.handType < other.cards.handType){
                -1
            } else {
                1
            }
        }
        return 0
    }

}