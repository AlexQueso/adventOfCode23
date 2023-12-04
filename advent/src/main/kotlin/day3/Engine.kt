package day3

class Engine(
    private val schematic: MutableList<MutableList<String>> = mutableListOf(),
    private var partNumbersSum: Int = 0,
    private var gearRatiosSum: Int = 0,
) {
    fun sumOfPartNumbers(): Int {
        for (index in 0 until schematic.size) {
            detectPartNumbers(index)
        }
        return partNumbersSum
    }

    private fun detectPartNumbers(schematicIndex: Int) {
        var lineIndex = 0
        while (lineIndex < schematic[schematicIndex].size) {
            val schematicEntry = getSchematicEntry(schematicIndex, lineIndex)
            if (isNumber(schematicEntry)) {
                val numberLength = getNumberLength(schematicIndex, lineIndex)
                addPartNumber(schematicIndex, lineIndex, numberLength)
                lineIndex += numberLength
            }
            lineIndex++
        }
    }

    private fun addPartNumber(schematicIndex: Int, lineIndex: Int, numberLength: Int) {
        if (hasAdjacentSymbol(schematicIndex, lineIndex, numberLength)) {
            val numberPart = getFullNumber(schematicIndex, lineIndex, numberLength)
            partNumbersSum += numberPart
        }
    }

    private fun hasAdjacentSymbol(schematicIndex: Int, lineIndex: Int, numberLength: Int): Boolean {
        return hasAdjacentSymbolAbove(schematicIndex, lineIndex, numberLength) ||
                hasAdjacentSymbolBefore(schematicIndex, lineIndex) ||
                hasAdjacentSymbolAfter(schematicIndex, lineIndex, numberLength) ||
                hasAdjacentSymbolBelow(schematicIndex, lineIndex, numberLength)
    }

    private fun hasAdjacentSymbolBelow(schematicIndex: Int, lineIndex: Int, numberLength: Int): Boolean {
        if (schematicIndex < schematic.size) {
            for (index in lineIndex - 1..lineIndex + numberLength) {
                try {
                    if (isSymbol(getSchematicEntry(schematicIndex + 1, index))) {
                        return true
                    }
                } catch (_: IndexOutOfBoundsException) { }
            }
        }
        return false
    }

    private fun hasAdjacentSymbolBefore(schematicIndex: Int, lineIndex: Int): Boolean {
        return try {
            isSymbol(getSchematicEntry(schematicIndex, lineIndex - 1))
        } catch (_: IndexOutOfBoundsException) {
            false
        }
    }

    private fun hasAdjacentSymbolAfter(schematicIndex: Int, lineIndex: Int, numberLength: Int): Boolean {
        return try {
            isSymbol(getSchematicEntry(schematicIndex, lineIndex + numberLength))
        } catch (_: IndexOutOfBoundsException) {
            false
        }
    }

    private fun hasAdjacentSymbolAbove(schematicIndex: Int, lineIndex: Int, numberLength: Int): Boolean {
        if (schematicIndex > 0) {
            for (index in lineIndex - 1..lineIndex + numberLength) {
                try {
                    if (isSymbol(getSchematicEntry(schematicIndex - 1, index))) {
                        return true
                    }
                } catch (_: IndexOutOfBoundsException) { }
            }
        }
        return false
    }

    private fun getFullNumber(schematicIndex: Int, lineIndex: Int, numberLength: Int): Int {
        return when (numberLength) {
            1 -> getSchematicEntry(schematicIndex, lineIndex).toInt()

            2 -> getSchematicEntry(schematicIndex, lineIndex).toInt() * 10 + getSchematicEntry(
                    schematicIndex,
                    lineIndex + 1
                ).toInt()

            else -> getSchematicEntry(schematicIndex, lineIndex).toInt() * 100 +
                        getSchematicEntry(schematicIndex, lineIndex + 1).toInt() * 10 +
                        getSchematicEntry(schematicIndex, lineIndex + 2).toInt()

        }
    }

    private fun isNumber(schematicEntry: String) = schematicEntry.toIntOrNull() != null

    private fun isSymbol(entry: String): Boolean {
        return entry == "*" || entry == "/" || entry == "=" || entry == "@" || entry == "&" || entry == "+" ||
                entry == "%" || entry == "$" || entry == "-" || entry == "#"
    }

    private fun isAsterisk(entry: String) = entry == "*"

    private fun getNumberLength(schematicEntry: Int, lineIndex: Int): Int {
        return try {
            if (!isNumber(getSchematicEntry(schematicEntry, lineIndex + 1))) {
                1
            } else if (!isNumber(getSchematicEntry(schematicEntry, lineIndex + 2))) {
                2
            } else {
                3
            }
        } catch (_: IndexOutOfBoundsException) {
            1
        }
    }

    private fun getSchematicEntry(schematicEntry: Int, lineIndex: Int) = schematic[schematicEntry][lineIndex]

    fun addSchematicLine(line: String) {
        val schematicLine = mutableListOf<String>()
        line.forEach {
            schematicLine.add(it.toString())
        }
        schematic.add(schematicLine)
    }

    fun sumOfGearRatios(): Int {
        for (index in 0 until schematic.size) {
            detectGears(index)
        }
        return gearRatiosSum
    }

    private fun detectGears(schematicIndex: Int) {
        schematic[schematicIndex].forEachIndexed { lineIndex, entry ->
            if (isAsterisk(entry) && isGear(schematicIndex, lineIndex)){
                addGearRatios(schematicIndex,lineIndex)
            }
        }
    }

    private fun addGearRatios(schematicIndex: Int, lineIndex: Int) {
        if (partNumbersAboveCount(schematicIndex,lineIndex) == 2){
            addGearRatiosAbove(schematicIndex,lineIndex)
        } else if (partNumbersBelowCount(schematicIndex, lineIndex) == 2){
            addGearRatiosBelow(schematicIndex, lineIndex)
        } else{
            addGearRatiosAround(schematicIndex,lineIndex)
        }
    }

    private fun addGearRatiosAround(schematicIndex: Int, lineIndex: Int) {
        val gearRatioUp = getGearRatioUp(schematicIndex,lineIndex)
        val gerRatioLeft = getGearRatioLeft(schematicIndex,lineIndex)
        val gearRatioRight = getGearRatioRight(schematicIndex,lineIndex)
        val gearRatioDown = getGearRatioDown(schematicIndex,lineIndex)
        gearRatiosSum += gearRatioUp * gerRatioLeft* gearRatioRight * gearRatioDown
    }

    private fun getGearRatioDown(schematicIndex: Int, lineIndex: Int): Int {
        return if (partNumbersBelowCount(schematicIndex, lineIndex) == 0) {
            1
        } else{
            getFullNumber2(schematicIndex+1, lineIndex)
        }
    }

    private fun getGearRatioRight(schematicIndex: Int, lineIndex: Int): Int {
        return if (partNumbersAfterCount(schematicIndex, lineIndex) == 0){
            1
        } else{
            getRightFullNumber(schematicIndex, lineIndex)
        }
    }

    private fun getGearRatioLeft(schematicIndex: Int, lineIndex: Int): Int {
        return if (partNumbersBeforeCount(schematicIndex, lineIndex) == 0){
            1
        } else{
            getLeftFullNumber(schematicIndex, lineIndex)
        }
    }

    private fun getGearRatioUp(schematicIndex: Int, lineIndex: Int): Int {
        return if (partNumbersAboveCount(schematicIndex, lineIndex) == 0) {
            1
        } else{
            getFullNumber2(schematicIndex-1, lineIndex)
        }
    }

    private fun getFullNumber2(schematicIndex: Int, lineIndex: Int): Int {
        if (isNumber(getSchematicEntry(schematicIndex,lineIndex))){
            return getMiddleFullNumber(schematicIndex, lineIndex)
        } else if (isNumber(getSchematicEntry(schematicIndex,lineIndex-1))) {
            return getLeftFullNumber(schematicIndex, lineIndex)
        } else {
            return getRightFullNumber(schematicIndex, lineIndex)
        }

    }

    private fun getRightFullNumber(schematicIndex: Int, lineIndex: Int): Int {
        var number = getSchematicEntry(schematicIndex, lineIndex + 1)
        if (isNumber(getSchematicEntry(schematicIndex, lineIndex + 2))) {
            number += getSchematicEntry(schematicIndex, lineIndex + 2)
            if (isNumber(getSchematicEntry(schematicIndex, lineIndex + 3))) {
                number += getSchematicEntry(schematicIndex, lineIndex + 3)
            }
        }
        return number.toInt()
    }

    private fun getLeftFullNumber(schematicIndex: Int, lineIndex: Int): Int {
        var number = getSchematicEntry(schematicIndex, lineIndex - 1)
        if (isNumber(getSchematicEntry(schematicIndex, lineIndex - 2))) {
            number = getSchematicEntry(schematicIndex, lineIndex - 2) + number
            if (isNumber(getSchematicEntry(schematicIndex, lineIndex - 3))) {
                number = getSchematicEntry(schematicIndex, lineIndex - 3) + number
            }
        }
        return number.toInt()
    }

    private fun getMiddleFullNumber(schematicIndex: Int, lineIndex: Int): Int {
        var number = getSchematicEntry(schematicIndex, lineIndex)
        if (isNumber(getSchematicEntry(schematicIndex, lineIndex - 1))) {
            number = getSchematicEntry(schematicIndex, lineIndex - 1) + number
            if (isNumber(getSchematicEntry(schematicIndex, lineIndex - 2))) {
                number = getSchematicEntry(schematicIndex, lineIndex - 2) + number
            } else if (isNumber(getSchematicEntry(schematicIndex, lineIndex + 1))) {
                number += getSchematicEntry(schematicIndex, lineIndex + 1)
            }
        } else {
            if (isNumber(getSchematicEntry(schematicIndex, lineIndex + 1))) {
                number += getSchematicEntry(schematicIndex, lineIndex + 1)
                if (isNumber(getSchematicEntry(schematicIndex, lineIndex + 2))) {
                    number += getSchematicEntry(schematicIndex, lineIndex + 2)
                }
            }
        }
        return number.toInt()
    }

    private fun addGearRatiosAbove(schematicIndex: Int, lineIndex: Int) { // xxx.xxx
        var leftNumberLength = 2
        if (isNumber(getSchematicEntry(schematicIndex-1,lineIndex-3))) {
            leftNumberLength = 3
        }
        val leftNumber = getFullNumber(schematicIndex-1,lineIndex-leftNumberLength,leftNumberLength)
        val rightNumberLength = getNumberLength(schematicIndex-1, lineIndex +1)
        val rightNumber = getFullNumber(schematicIndex-1, lineIndex+1, rightNumberLength)
        gearRatiosSum += leftNumber * rightNumber
    }

    private fun addGearRatiosBelow(schematicIndex: Int, lineIndex: Int) { // xxx.xxx
        var leftNumberLength = 2
        if (isNumber(getSchematicEntry(schematicIndex+1,lineIndex-3))) {
            leftNumberLength = 3
        }
        val leftNumber = getFullNumber(schematicIndex+1,lineIndex-leftNumberLength,leftNumberLength)
        val rightNumberLength = getNumberLength(schematicIndex+1, lineIndex +1)
        val rightNumber = getFullNumber(schematicIndex+1, lineIndex+1, rightNumberLength)
        gearRatiosSum += leftNumber * rightNumber
    }

    private fun isGear(schematicIndex: Int, lineIndex: Int): Boolean {
        return (partNumbersAboveCount(schematicIndex, lineIndex) +
                partNumbersBeforeCount(schematicIndex, lineIndex) +
                partNumbersAfterCount(schematicIndex, lineIndex) +
                partNumbersBelowCount(schematicIndex, lineIndex)) == 2
    }

    private fun partNumbersBeforeCount(schematicIndex: Int, lineIndex: Int): Int {
        if (getSchematicEntry(schematicIndex,lineIndex-1)[0].isDigit()){
            return 1
        }
        return 0
    }

    private fun partNumbersAfterCount(schematicIndex: Int, lineIndex: Int): Int {
        if (getSchematicEntry(schematicIndex,lineIndex+1)[0].isDigit()){
            return 1
        }
        return 0
    }

    private fun partNumbersBelowCount(schematicIndex: Int, lineIndex: Int): Int {
        val belowEntries = getEntries(schematicIndex+1,lineIndex)
        return getNumberOfPartNumbersInEntry(belowEntries)
    }

    private fun partNumbersAboveCount(schematicIndex: Int, lineIndex: Int): Int {
        val aboveEntries = getEntries(schematicIndex-1,lineIndex)
        return getNumberOfPartNumbersInEntry(aboveEntries)
    }

    private fun getNumberOfPartNumbersInEntry(entries: String): Int {
        return if (entries == "...") {
            0
        } else if (hasTwoPartNumbers(entries)) {
            2
        } else {
            1
        }
    }

    private fun hasTwoPartNumbers(entries: String): Boolean {
        return entries[0].isDigit() && entries[1] == '.' && entries[2].isDigit()
    }

    private fun getEntries(schematicIndex: Int, lineIndex: Int): String {
        return getSchematicEntry(schematicIndex, lineIndex-1) +
                getSchematicEntry(schematicIndex, lineIndex) +
                getSchematicEntry(schematicIndex, lineIndex+1) 
    }

}