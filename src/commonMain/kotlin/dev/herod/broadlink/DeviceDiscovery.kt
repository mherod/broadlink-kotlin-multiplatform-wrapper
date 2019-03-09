package dev.herod.broadlink

expect object DeviceDiscovery {
    fun discover(): List<BroadlinkDevice>
}
