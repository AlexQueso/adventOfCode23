package twentyThree.day04

import java.io.File

class CardGame(private val cardGameInput: File) {
    private var scratchCards = getOriginalCardList()
    private var originalScratchCards = getOriginalCardList()

    fun scratchCardsAmount(): Int {
        var scratchCardsIndex = 0
        while (scratchCardsIndex < scratchCards.size) {
            addDuplicatedScratchCards(scratchCardsIndex)
            scratchCardsIndex++
        }
        return scratchCards.size
    }

    private fun addDuplicatedScratchCards(index: Int) {
        val cardMatchingNumberAmount = scratchCards[index].getCardMatchingNumbers()
        val cardId = scratchCards[index].id
        for (originalScratchCardIndex in cardId until cardId + cardMatchingNumberAmount) {
            scratchCards.add(originalScratchCards[originalScratchCardIndex].copy())
        }
    }

    private fun getOriginalCardList(): MutableList<Card> {
        val list = mutableListOf<Card>()
        cardGameInput.forEachLine {
            list.add(CardRecord(it).getCard())
        }
        return list
    }
}