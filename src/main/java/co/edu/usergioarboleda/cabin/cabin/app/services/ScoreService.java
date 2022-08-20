package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.cabin.cabin.app.repository.ScoreRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Score;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;

    public List<Score> getAll() {
        return repository.findAll();
    }

    public Optional<Score> getById(Integer id) {
        return repository.findById(id);
    }

    public Score save(Score score) {
        if (score.getId() == null) {
            return repository.save(score);
        } else {
            if (repository.findById(score.getId()) == null) {
                return repository.save(score);
            } else {
                // throw new RuntimeException("Score not found");
                return score;
            }
        }
    }

    /*
     * public Score update(Score score) {
     * if (score.getId() != null) {
     * Optional<Score> optionalScore = repository.findById(score.getId());
     * if (optionalScore.isPresent()) {
     * if (score.getName() != null) {
     * optionalScore.get().setName(score.getName());
     * }
     * if (score.getDescription() != null) {
     * optionalScore.get().setDescription(score.getDescription());
     * }
     * return repository.save(optionalScore.get());
     * } else {
     * // throw new RuntimeException("Score not found");
     * return score;
     * }
     * } else {
     * // throw new RuntimeException("Score not found");
     * return score;
     * }
     * }
     */
    public void delete(Score score) {
        if (score.getId() != null) {
            Optional<Score> optionalScore = repository.findById(score.getId());
            if (optionalScore.isPresent()) {
                repository.delete(score);
            } else {
                // throw new RuntimeException("Score not found");
            }
        } else {
            // throw new RuntimeException("Score not found");
        }

    }

    /*
     * 
     * public void delete(Integer id) {
     * repository.deleteById(id);
     * }
     * 
     * public List<Score> getByName(String name) {
     * return repository.findByName(name);
     * }
     * 
     * public List<Score> getByScore(String score) {
     * return repository.findByScore(score);
     * }
     * 
     * public List<Score> getByPrice(Double price) {
     * return repository.findByPrice(price);
     * }
     * 
     */

}