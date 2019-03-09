package dev.herod.broadlink

expect interface BroadlinkDevice {
    fun enterLearning(): Boolean
    fun fetchLearnedPayload(): ByteArray?
    fun sendCommandPayload(payload: ByteArray)
}

