package Service;

import Model.Score;
import Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score score){
        if (score.getIdScore() == null){
            return scoreRepository.save(score);
        }else {
            Optional<Score> scoreEncontrado = getScore(score.getIdScore());
            if (scoreEncontrado.isEmpty()){
                return scoreRepository.save(score);
            }
            return score;
        }
    }

    public Score update(Score score){
        if (score.getIdScore() != null){
            Optional<Score> scoreEncontrado = getScore(score.getIdScore());
            if (!scoreEncontrado.isEmpty()){
                if (score.getMessageText() != null){
                    scoreEncontrado.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null){
                    scoreEncontrado.get().setStars(score.getStars());
                }
                return scoreRepository.save(scoreEncontrado.get());
            }
        }
        return score;
    }

    public boolean delete(int id){
        Boolean respuesta = getScore(id).map(elemento ->{
            scoreRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
