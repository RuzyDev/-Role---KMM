package com.ruzy.maisrole.network

import com.ruzy.maisrole.util.Constants.BASE_URL
import com.ruzy.maisrole.util.datastore.Keys
import com.ruzy.maisrole.util.datastore.MaisRoleDataStore
import com.ruzy.maisrole.util.log.CommonLoggerImpl
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BasicAuthCredentials
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.basic
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import io.ktor.http.parameters
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.datetime.LocalDate
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class KtorHttpClient(
    private val maisroleDataStore: MaisRoleDataStore
) {
    fun httpClient(enableNetworkLogs: Boolean) = HttpClient {
        expectSuccess = false

        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = BASE_URL
//                headers {
//                    append(HttpHeaders.Authorization, "Basic 3f1b14be-41cb-43c9-a5a7-5ae72c47c1ad,Bearer ${token.accessToken}")
//                }
            }
        }

        if (enableNetworkLogs) {
            install(Logging) {
                level = LogLevel.HEADERS
                logger = object : Logger {
                    override fun log(message: String) {
                        CommonLoggerImpl().log(tag = "Http Client", message = message)
                    }
                }
            }
        }

        install(Auth) {
            bearer {
//                refreshTokens {
//                    val refreshTokenInfo: String = client.post {
//                        url("https://cdn02.arcom.com.br/frontstack/login")
//                        contentType(ContentType.Application.Json)
//                        setBody(
//                            NetworkSolicitaDeviceToken(
//                                25, getPassword()
//                            )
//                        )
//                    }.body()
//                    val bearer = BearerTokens(refreshTokenInfo, refreshTokenInfo)
//                    maisroleDataStore.emitString(Json.encodeToString(bearer), Keys.TOKEN_BEARER)
//                    bearer
//                }
//                loadTokens {
//                    token
//                }
            }
        }

        install(HttpTimeout) {
            val timeout = 30000L
            connectTimeoutMillis = timeout
            requestTimeoutMillis = timeout
            socketTimeoutMillis = timeout
        }

        install(ResponseObserver) {
            onResponse { response ->
                println("AppDebug HTTP ResponseObserver status: ${response.status.value}")
            }
        }
        HttpResponseValidator {
            validateResponse { response: HttpResponse ->
                val statusCode = response.status.value

                if (statusCode == 401) {

                }

                /*
                                    when (statusCode) {
                                        in 300..399 -> throw RedirectResponseException(response)
                                        in 400..499 -> throw ClientRequestException(response)
                                        in 500..599 -> throw ServerResponseException(response)
                                    }

                                    if (statusCode >= 600) {
                                        throw ResponseException(response)
                                    }
                                }

                                handleResponseException { cause: Throwable ->
                                    throw cause
                                }*/
            }
        }

        install(Logging) {
            //  logger = Logger.DEFAULT
            level = LogLevel.ALL

            logger = object : Logger {
                override fun log(message: String) {
                    println("AppDebug KtorHttpClient message:$message")
                }
            }
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }

    }
}


private fun getPassword(): String {
    var senha: Long
    val lAno: Long
    val sSenha: String

    // Calcula Senha do dia
    val dateStr = "26/08/2024"
    lAno = dateStr.substring(6, 10).toLong()
    sSenha = dateStr.replace("/", "")
    senha = sSenha.toLong()
    senha = senha xor lAno
    senha = senha shr 1
    return senha.toString()
}
