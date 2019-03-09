package sample

import dev.herod.broadlink.DeviceDiscovery
import org.junit.Test
import kotlin.test.assertTrue

class DeviceDiscoveryTest {

    @Test
    fun discover() {
        val list = DeviceDiscovery.discover()
//        assertTrue(list.isNotEmpty())
        assertTrue(list.all { it.enterLearning() })
        assertTrue(list.all { it.fetchLearnedPayload() == null })
    }
}
