package rsa

import enumstorage.update.ApplicationName
import org.json.JSONObject

object RsaEncryptionModuleRunner {
    fun getUpdateInformation(): JSONObject = UpdateInformation.getAsJson(applicationName = ApplicationName.Rsa.name)
}