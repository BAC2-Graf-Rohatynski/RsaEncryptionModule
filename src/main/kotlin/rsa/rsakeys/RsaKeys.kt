package rsa.rsakeys

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import rsa.rsakeys.interfaces.IRsaKeys
import java.lang.Exception
import java.security.*

object RsaKeys: IRsaKeys {
    private val logger: Logger = LoggerFactory.getLogger(RsaKeys::class.java)
    private var publicKey: PublicKey? = null
    private var privateKey: PrivateKey? = null

    init {
        generateNewKeys()
    }

    @Synchronized
    override fun getPublicKey(): PublicKey? = publicKey ?: generateNewKeys()?.public ?: throw Exception("Public RSA key cannot be loaded!")

    @Synchronized
    override fun getPrivateKey(): PrivateKey? = privateKey ?: generateNewKeys()?.private ?: throw Exception("Private RSA key cannot be loaded!")

    @Synchronized
    override fun generateNewKeys(): KeyPair? {
        return try {
            logger.info("Loading new RSA keys ...")
            val rsaKeys = RsaKeyPairGenerator.generateNewRsaKeys()
            publicKey = rsaKeys.public
            privateKey = rsaKeys.private
            logger.info("New RSA keys loaded")
            rsaKeys
        } catch (ex: Exception) {
            logger.error("Error occurred while loading RSA keys!\n${ex.message}")
            null
        }
    }
}