package com.xzg.wlxx.library.entity;

/**
 * @author XiaoZG
 */
//@Mapper
public interface AnimalMapper {
//    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    Animal toPo(Dog dog);
}
