package com.mosayed.manex.data.transactions

import com.mosayed.manex.data.transactions.dto.TransactionsResponse
import com.mosayed.manex.data.transactions.dto.toEntity
import com.mosayed.manex.data.utils.ApiConstants
import com.mosayed.manex.domain.GeneralException
import com.mosayed.manex.domain.transactions.ITransactionsRemoteService
import com.mosayed.manex.domain.transactions.TransactionEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionsRemoteService @Inject constructor(
    private val client: HttpClient,
) : ITransactionsRemoteService {
    override suspend fun getTransactions(): List<TransactionEntity> {
        try {
            val response = client.get(ApiConstants.GET_TRANSACTIONS_ENDPOINT)
            if (response.status == HttpStatusCode.OK) {
                val transactionsResponse: TransactionsResponse =
                    Json.decodeFromString(response.body<String>().replace("'", "\""))
                return transactionsResponse.transactions?.filterNotNull()?.map { it.toEntity() }
                    ?: emptyList()
            }
            throw GeneralException("حاول مجداا")
        } catch (e: Exception) {
            throw GeneralException(e.message ?: "حدث خطأ")
        }
    }
}