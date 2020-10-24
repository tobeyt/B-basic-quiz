package com.tw.qd.tool;

import com.tw.qd.dto.Education;
import com.tw.qd.dto.User;
import com.tw.qd.entity.EducationEntity;
import com.tw.qd.entity.UserEntity;

public class Convert {
    public static User convetToUserDto(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .age(userEntity.getAge())
                .description(userEntity.getDescription())
                .avatar(userEntity.getAvatar())
                .name(userEntity.getName())
                .build();
    }

    public static UserEntity converToUserEntity(User user) {
        return UserEntity.builder()
                .name(user.getName())
                .age(user.getAge())
                .avatar(user.getAvatar())
                .description(user.getDescription())
                .build();
    }

    public static Education convetToEducationDto(EducationEntity educationEntity) {
        return Education.builder()
                .title(educationEntity.getTitle())
                .year(educationEntity.getYear())
                .description(educationEntity.getDescription())
                .userId(educationEntity.getUserEntity().getId())
                .build();
    }

    public static EducationEntity convertToEducationEntity(Education education, UserEntity userEntity){
        return EducationEntity.builder()
                .description(education.getDescription())
                .title(education.getTitle())
                .userEntity(userEntity)
                .year(education.getYear())
                .build();
    }
}
