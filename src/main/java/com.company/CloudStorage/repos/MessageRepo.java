package com.company.CloudStorage.repos;

import com.company.CloudStorage.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {

}