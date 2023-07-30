package top.mark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import top.mark.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
