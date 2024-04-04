package bip.online.biplio2023.repository;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishRepo extends JpaRepository<PublisherEntity, Long> {
}
