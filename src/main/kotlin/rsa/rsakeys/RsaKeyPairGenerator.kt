package rsa.rsakeys

import rsa.rsakeys.interfaces.IRsaKeyPairGenerator
import java.security.*

object RsaKeyPairGenerator: IRsaKeyPairGenerator {
    @Synchronized
    override fun generateNewRsaKeys(): KeyPair {
        val keyGenerator = KeyPairGenerator.getInstance("RSA")
        keyGenerator.initialize(12288)
        return keyGenerator.generateKeyPair()
    }
}