package org.springframework.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gancha on 31/1/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
