package com.example.oneToOneMapping.mapper;

import com.example.oneToOneMapping.entity.AddressEntity;
import com.example.oneToOneMapping.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressEntity addressToEntity(Address address);
    Address entityToAddress(AddressEntity addressEntity);
}
