package com.xzg.wlxx.library.entity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author XiaoZG
 */
@Mapper
public interface AnimalMapper {
    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    Animal toPo(Dog dog);
}
