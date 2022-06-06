package com.bendingbytes.shoes.network

interface EntityMapper<NetworkEntity, DomainEntity> {
    fun mapFromEntity(entity: NetworkEntity): DomainEntity

    fun mapToEntity(domainModel: DomainEntity): NetworkEntity
}