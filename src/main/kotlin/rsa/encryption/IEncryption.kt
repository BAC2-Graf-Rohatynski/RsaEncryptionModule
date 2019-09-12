package rsa.encryption

interface IEncryption {
    fun encrypt(message: String): String
    fun decrypt(message: String): String
}