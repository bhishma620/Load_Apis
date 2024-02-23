package com.bhishma.springjpa.repostory;

import com.bhishma.springjpa.entity.Payload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoadRepo extends JpaRepository<Payload,Integer> {
List<Payload>findByShipperId(int shipperId);

  Payload findByLoadId(int loadId);
}
