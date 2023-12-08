package day07

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