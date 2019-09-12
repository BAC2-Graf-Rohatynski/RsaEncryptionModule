package rsa.encryption

import rsa.rsakeys.RsaKeys
import javax.crypto.Cipher
import java.util.*

object Encryption: IEncryption {
    @Synchronized
    override fun encrypt(message: String): String {
        try {
            return message
            /*
            val cipherInstance = Cipher.getInstance("RSA/ECB/PKCS1Padding")
            cipherInstance.init(Cipher.ENCRYPT_MODE, RsaKeys.getPublicKey())
            val cipherText = cipherInstance.doFinal(message.toByteArray())
            return Base64.getEncoder().encodeToString(cipherText)
            */
        } catch (ex: Exception) {
            throw Exception("Error occurred while encrypting message!\n${ex.message}")
        }
    }

    @Synchronized
    override fun decrypt(message: String): String {
        try {
            return message
            /*
            val decodedCipherText = Base64.getDecoder().decode(message.toByteArray())
            val cipherInstance = Cipher.getInstance("RSA/ECB/PKCS1Padding")
            cipherInstance.init(Cipher.DECRYPT_MODE, RsaKeys.getPrivateKey())
            val plainText = cipherInstance.doFinal(decodedCipherText)
            return String(plainText)
            */
        } catch (ex: Exception) {
            throw Exception("Error occurred while decrypting message!\n${ex.message}")
        }
    }
}