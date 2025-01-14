package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.dal.entity.ReponseEntity;
import com.easyrecruit.interview.dal.entity.ReponseUtilisateurEntity;
import com.easyrecruit.interview.infra.Entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T10:26:16+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class QuestionConverterImpl implements QuestionConverter {

    @Override
    public QuestionEntity toEntity(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionEntity questionEntity = new QuestionEntity();

        List<ReponseEntity> list = question.getResponses();
        if ( list != null ) {
            questionEntity.setResponses( new ArrayList<ReponseEntity>( list ) );
        }
        questionEntity.setId( question.getId() );
        questionEntity.setText( question.getText() );
        questionEntity.setCorrectAnswer( question.getCorrectAnswer() );
        questionEntity.setTopic( question.getTopic() );
        List<ReponseUtilisateurEntity> list1 = question.getListResponses();
        if ( list1 != null ) {
            questionEntity.setListResponses( new ArrayList<ReponseUtilisateurEntity>( list1 ) );
        }

        return questionEntity;
    }

    @Override
    public Question fromEntity(QuestionEntity questionEntity) {
        if ( questionEntity == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( questionEntity.getId() );
        question.setText( questionEntity.getText() );
        question.setCorrectAnswer( questionEntity.getCorrectAnswer() );
        question.setTopic( questionEntity.getTopic() );
        List<ReponseEntity> list = questionEntity.getResponses();
        if ( list != null ) {
            question.setResponses( new ArrayList<ReponseEntity>( list ) );
        }
        List<ReponseUtilisateurEntity> list1 = questionEntity.getListResponses();
        if ( list1 != null ) {
            question.setListResponses( new ArrayList<ReponseUtilisateurEntity>( list1 ) );
        }

        return question;
    }
}
