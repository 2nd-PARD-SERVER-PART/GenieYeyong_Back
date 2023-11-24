package pard.dragon.genie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.dragon.genie.entity.WishEntity;

import java.util.List;

public interface WishRepository extends JpaRepository<WishEntity, Integer> {
    List<WishEntity> findByType(String type);
    WishEntity findByPassword(String password);
}
