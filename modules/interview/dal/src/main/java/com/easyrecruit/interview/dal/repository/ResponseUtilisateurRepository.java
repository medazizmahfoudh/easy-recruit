package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.Question;
import com.easyrecruit.interview.dal.entity.Response;
import com.easyrecruit.interview.dal.entity.ResponseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ResponseUtilisateurRepository extends JpaRepository<ResponseUser, Long> {

    /**
     * Récupère les réponses utilisateur en fonction de l'ID du candidat.
     *
     * @param candidatId L'ID du candidat.
     * @return Liste des réponses utilisateur associées à ce candidat.
     */
    List<ResponseUser> findByCandidatId(Long candidatId);

    /**
     * Trouve une réponse utilisateur basée sur la question et la réponse donnée.
     *
     * @param question La question associée.
     * @param response  La réponse associée.
     * @return Une réponse utilisateur si elle existe.
     */
    Optional<ResponseUser> findByQuestionAndReponse(Question question, Response response);

    /**
     * Trouve la réponse correcte pour une question donnée.
     *
     * @param question La question pour laquelle trouver la bonne réponse.
     * @return La réponse correcte.
     */
    @Query("SELECT r FROM Response r WHERE r.question = :question AND r.correct = true")
    Response findCorrectReponseByQuestion(@Param("question") Question question);


}
