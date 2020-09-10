package com.seu.ums.Repository;

import com.seu.ums.Entity.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface SchoolRepository extends CrudRepository<School, Integer> {
}
