package dev.herod.broadlink

import com.github.mob41.blapi.BLDevice
import com.github.mob41.blapi.RM2Device
import com.github.mob41.blapi.pkt.cmd.rm2.SendDataCmdPayload

actual object DeviceDiscovery {
    @JvmStatic
    actual fun discover(): List<BroadlinkDevice> {
        return BLDevice.discoverDevices().filterIsInstance<RM2Device>().map {
            object : BroadlinkDevice {
                private val device: RM2Device by lazy { it.also { it.auth() } }
                override fun enterLearning() = device.enterLearning()
                override fun fetchLearnedPayload(): ByteArray? = device.checkData()
                override fun sendCommandPayload(payload: ByteArray) {
                    device.sendCmdPkt(SendDataCmdPayload(payload))
                }
            }
        }
    }
}
