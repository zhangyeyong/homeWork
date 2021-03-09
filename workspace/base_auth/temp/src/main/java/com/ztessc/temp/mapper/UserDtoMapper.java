package com.ztessc.temp.mapper;

/**  
 * All rights Reserved, Designed By www.ztessc.com
 * @Title:  UserDtoMapper.java   
 * @Package com.ztessc.temp.mapper   
 * @Description:  
 * @author: 张业勇     
 * @date:   2018年11月10日   
 * @version V1.0 
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved. 
 */
import org.mapstruct.Mapper;

import com.ztessc.temp.dto.UserDto;
import com.ztessc.temp.pojo.User;

@Mapper(componentModel="spring")
public interface UserDtoMapper {
    
    
    public User dtoToUser(UserDto userDto) ;
    public UserDto userToDto(User user);

}
