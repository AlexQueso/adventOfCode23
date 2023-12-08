package day07

class CamelCards(private val hands: MutableList<Hand>) {

    fun totalWinnings(): Int {
        hands.sort()
        var winnings = 0
        hands.forEachIndexed { index, hand ->
            winnings += hand.bid * (index+1)
        }
        return winnings
    }
}

class CamelCardsRecord(private val record: List<String>) {
    private val hands = mutableListOf<Hand>()
    fun getCamelCards(): CamelCards {
        record.forEach {
            hands.add(HandRecord(it).getHand())
        }
        return CamelCards(hands)
    }
}

class HandRecord(private val line: String) {
    fun getHand() : Hand {
        val cardsAndBit = line.split(" ")
        return Hand(cardsAndBit[0], cardsAndBit[1].toInt())
    }
}