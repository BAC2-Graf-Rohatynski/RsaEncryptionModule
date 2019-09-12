package rsa.rsakeys.interfaces

import java.security.KeyPair

interface IRsaKeyPairGenerator {
    fun generateNewRsaKeys(): KeyPair
}