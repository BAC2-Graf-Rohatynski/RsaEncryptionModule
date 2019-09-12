package rsa.rsakeys.interfaces

import java.security.KeyPair
import java.security.PrivateKey
import java.security.PublicKey

interface IRsaKeys {
    fun getPublicKey(): PublicKey?
    fun getPrivateKey(): PrivateKey?
    fun generateNewKeys(): KeyPair?
}