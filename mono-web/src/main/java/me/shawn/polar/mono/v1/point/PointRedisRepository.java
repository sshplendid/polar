package me.shawn.polar.mono.v1.point;

import org.springframework.data.repository.CrudRepository;

public interface PointRedisRepository extends CrudRepository<Point, String> {

}
