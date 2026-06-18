package cat.itacademy.s04.t02.n02.fruit.repository.fruit;

import cat.itacademy.s04.t02.n02.fruit.model.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

}
