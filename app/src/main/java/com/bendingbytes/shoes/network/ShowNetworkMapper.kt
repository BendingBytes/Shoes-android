package com.bendingbytes.shoes.network

import com.bendingbytes.shoes.domain.Shoe


class ShowNetworkMapper : EntityMapper<ShoeNetworkEntity, Shoe> {
    override fun mapFromEntity(entity: ShoeNetworkEntity): Shoe {
        return Shoe(
            id = entity.id,
            name = entity.name,
            price = entity.price,
            image = entity.image,
            description = entity.description
        )
    }

    override fun mapToEntity(domainModel: Shoe): ShoeNetworkEntity {
        return ShoeNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            price = domainModel.price,
            image = domainModel.image,
            description = domainModel.description
        )
    }
}