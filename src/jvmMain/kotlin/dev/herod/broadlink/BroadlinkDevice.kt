package dev.herod.broadlink

actual interface BroadlinkDevice {
    actual fun enterLearning(): Boolean
    actual fun fetchLearnedPayload(): ByteArray?
    actual fun sendCommandPayload(payload: ByteArray)
}
