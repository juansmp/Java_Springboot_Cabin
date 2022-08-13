package co.edu.usergioarboleda.cabin.cabin.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.cabin.cabin.app.models.Score;
import co.edu.usergioarboleda.cabin.cabin.app.repository.crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository repository;

    public List<Score> findAll() {
        return (List<Score>) repository.findAll();
    }

    public Optional<Score> findById(Integer id) {
        return repository.findById(id);
    }
    /* Another implementation for findByid would be the following */
    /*
     * public Score findById(Integer id) {
     * return repository.findById(id).orElse(null);
     * }
     */

    public Score save(Score score) {
        return repository.save(score);
    }

    public void delete(Score score) {
        repository.delete(score);
    }

}
