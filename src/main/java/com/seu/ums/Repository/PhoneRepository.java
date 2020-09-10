package com.seu.ums.Repository;

import com.seu.ums.Entity.Phone;
import com.seu.ums.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends JpaRepository<Phone,Integer> {
}
