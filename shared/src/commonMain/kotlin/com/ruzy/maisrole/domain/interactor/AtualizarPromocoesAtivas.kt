package com.ruzy.maisrole.domain.interactor

import com.ruzy.maisrole.domain.Interactor
import com.ruzy.maisrole.domain.repository.MaisRoleRepository
import com.ruzy.maisrole.util.AppCoroutineDispatchers
import kotlinx.coroutines.withContext

//class AtualizarMaisRoleAtivas(
//    private val maisRoleRepository: MaisRoleRepository,
//    private val dispatchers: AppCoroutineDispatchers
//) : Interactor<AtualizarMaisRoleAtivas.Params, Unit>() {
//
//    override suspend fun doWork(params: Params) {
//        withContext(dispatchers.io) {
//            if (params.dadosUsuario == null) {
//                throw Exception("Dados do usuário não encontrados")
//            } else {
//                maisRoleRepository.fetchMaisRoleAtivasFromRemote(
//                    params.dadosUsuario.idSegmento,
//                    params.dadosUsuario.idRegiaoVenda,
//                    params.dadosUsuario.estado
//                )
//                maisRoleRepository.fetchMaisRoleClientesFromRemote(
//                    params.dadosUsuario.idSegmento,
//                    params.dadosUsuario.idRegiaoVenda,
//                    params.dadosUsuario.estado
//                )
//            }
//        }
//    }
//
//    data class Params(val dadosUsuario: DadosUsuario?)
//}