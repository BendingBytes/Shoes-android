package com.bendingbytes.shoes.data

import com.bendingbytes.shoes.domain.Shoe
import com.bendingbytes.shoes.network.EntityMapper
import com.bendingbytes.shoes.network.ShoeNetworkEntity

class ShoeCacheMapper : EntityMapper<ShoeData, Shoe> {
    override fun mapFromEntity(entity: ShoeData): Shoe {
        return Shoe(
            id = entity.id,
            name = entity.name,
            price = entity.price,
            image = entity.image,
            description = entity.description
        )
    }

    override fun mapToEntity(domainModel: Shoe): ShoeData {
        return ShoeData(
            id = domainModel.id,
            name = domainModel.name,
            price = domainModel.price,
            image = domainModel.image,
            description = domainModel.description
        )
    }
}