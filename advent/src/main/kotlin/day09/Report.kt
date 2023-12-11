package day09

class Report(private val sequences: List<Sequence>) {
    fun sumOfExtraLastValues(): Int {
        calculateExtraLastValues()
        var sum = 0
        sequences.forEach {
            sum += it.getExtraLastValue()
        }
        return sum
    }

    private fun calculateExtraLastValues() {
        sequences.forEach { it.calculateExtraLastValue() }
    }

    fun sumOfExtraPreviousValues(): Int {
        calculateExtraPreviousValues()
        var sum = 0
        sequences.forEach {
            sum += it.getExtraPreviousValue()
        }
        return sum
    }

    private fun calculateExtraPreviousValues() {
        sequences.forEach { it.calculateExtraPreviousValue() }
    }
}

class ReportRecord(private val record: List<String>) {
    private val sequences = mutableListOf<Sequence>()
    fun getReport(): Report {
        record.forEach {
            sequences.add(SequenceRecord(it).getSequence())
        }
        return Report(sequences)
    }
}