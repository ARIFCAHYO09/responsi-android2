package com.example.cahyo.fpandroid.repository

import com.example.cahyo.fpandroid.model.entity.TeamEntity
import io.reactivex.Observable
import io.reactivex.Single

interface FavoriteTeamRepository {

    fun insert(teamEntity: TeamEntity): Single<Boolean>

    fun find(teamId: String): Single<TeamEntity>

    fun findAll(): Observable<TeamEntity>

    fun delete(teamId: String): Single<Boolean>

    fun isExist(teamId: String): Single<Boolean>
}