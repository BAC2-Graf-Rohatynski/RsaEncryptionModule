package rsa

import org.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import enumstorage.update.UpdateInformation.Application
import enumstorage.update.UpdateInformation.Changes
import enumstorage.update.UpdateInformation.Version
import enumstorage.update.UpdateInformation.Update
import java.util.*

object UpdateInformation {
    private val logger: Logger = LoggerFactory.getLogger(UpdateInformation::class.java)

    fun getAsJson(applicationName: String): JSONObject {
        return try {
            val properties = Properties()
            val presetsStream = UpdateInformation::class.java.classLoader.getResourceAsStream("update.properties")
            properties.load(presetsStream)

            val isUpdate = properties.getProperty("$applicationName.${Update.name.toLowerCase()}")?.toBoolean() ?: throw Exception("Field '${Update.name.toLowerCase()}' is null or not existing for $applicationName!")
            val version = properties.getProperty("$applicationName.${Version.name.toLowerCase()}") ?: throw Exception("Field '${Version.name.toLowerCase()}' is null or not existing for $applicationName!")
            val changes = properties.getProperty("$applicationName.${Changes.name.toLowerCase()}") ?: throw Exception("Field '${Changes.name.toLowerCase()}' is null or not existing for $applicationName!")
            val application = properties.getProperty("$applicationName.${Application.name.toLowerCase()}") ?: throw Exception("Field '${Application.name.toLowerCase()}' is null or not existing for $applicationName!")

            if (isUpdate) {
                logger.info("Updates available")
                properties.setProperty("$applicationName.${Update.name.toLowerCase()}", false.toString())
                JSONObject()
                        .put(Application.name, application)
                        .put(Version.name, version)
                        .put(Changes.name, changes)
            } else {
                logger.info("No updates available")
                JSONObject()
            }
        } catch (ex: Exception) {
            logger.error("Error occurred while requesting update information!\n${ex.message}")
            JSONObject()
        }
    }

    fun getAsJson(applicationName: String, version: String, changes: String): JSONObject = JSONObject()
            .put(enumstorage.update.UpdateInformation.Application.name, applicationName)
            .put(enumstorage.update.UpdateInformation.Version.name, version)
            .put(enumstorage.update.UpdateInformation.Changes.name, changes)
}