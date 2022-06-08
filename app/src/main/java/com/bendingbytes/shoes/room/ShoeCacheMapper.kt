package com.bendingbytes.shoes.room

import com.bendingbytes.shoes.domain.Shoe
import com.bendingbytes.shoes.network.EntityMapper

class ShoeCacheMapper : EntityMapper<ShoeCacheEntity, Shoe> {
    override fun mapFromEntity(entity: ShoeCacheEntity): Shoe {
        return Shoe(
            id = entity.id,
            name = entity.name,
            price = entity.price,
            image = entity.image,
            description = entity.description
        )
    }

    override fun mapToEntity(domainModel: Shoe): ShoeCacheEntity {
        return ShoeCacheEntity(
            id = domainModel.id,
            name = domainModel.name,
            price = domainModel.price,
            image = domainModel.image,
            description = domainModel.description
        )
    }
}