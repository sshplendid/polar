package me.shawn.polar.mono.v1.auth;

import org.springframework.data.repository.CrudRepository;

public interface AuthRedisRepository extends CrudRepository<AuthResultModel, String> {

}
