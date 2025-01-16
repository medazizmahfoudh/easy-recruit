package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.dal.entity.ResponseEntity;
import com.easyrecruit.interview.dal.entity.ResponseUserEntity;
import com.easyrecruit.interview.infra.Entity.Question;
import com.easyrecruit.interview.infra.Entity.Response;
import com.easyrecruit.interview.infra.Entity.ResponseUser;
import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.infra.model.entity.Candidate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-16T16:44:26+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Ubuntu)"
)
public class ResponseConverterImpl implements ResponseConverter {

    @Override
    public ResponseEntity toEntity(Response response) {
        if ( response == null ) {
            return null;
        }

        ResponseEntity responseEntity = new ResponseEntity();

        responseEntity.setId( response.getId() );
        responseEntity.setCorrect( response.isCorrect() );
        responseEntity.setResponseText( response.getResponseText() );
        responseEntity.setQuestion( questionToQuestionEntity( response.getQuestion() ) );

        return responseEntity;
    }

    @Override
    public Response fromEntity(ResponseEntity responseEntity) {
        if ( responseEntity == null ) {
            return null;
        }

        Response response = new Response();

        response.setId( responseEntity.getId() );
        response.setCorrect( responseEntity.isCorrect() );
        response.setResponseText( responseEntity.getResponseText() );
        response.setQuestion( questionEntityToQuestion( responseEntity.getQuestion() ) );

        return response;
    }

    protected List<ResponseEntity> responseListToResponseEntityList(List<Response> list) {
        if ( list == null ) {
            return null;
        }

        List<ResponseEntity> list1 = new ArrayList<ResponseEntity>( list.size() );
        for ( Response response : list ) {
            list1.add( toEntity( response ) );
        }

        return list1;
    }

    protected CandidateEntity candidateToCandidateEntity(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateEntity candidateEntity = new CandidateEntity();

        candidateEntity.setId( candidate.getId() );
        if ( candidate.getUuid() != null ) {
            candidateEntity.setUuid( UUID.fromString( candidate.getUuid() ) );
        }
        candidateEntity.setFirstname( candidate.getFirstname() );
        candidateEntity.setLastname( candidate.getLastname() );
        candidateEntity.setEmail( candidate.getEmail() );

        return candidateEntity;
    }

    protected ResponseUserEntity responseUserToResponseUserEntity(ResponseUser responseUser) {
        if ( responseUser == null ) {
            return null;
        }

        ResponseUserEntity responseUserEntity = new ResponseUserEntity();

        responseUserEntity.setId( responseUser.getId() );
        responseUserEntity.setCandidate( candidateToCandidateEntity( responseUser.getCandidate() ) );
        responseUserEntity.setQuestion( questionToQuestionEntity( responseUser.getQuestion() ) );
        responseUserEntity.setResponse( toEntity( responseUser.getResponse() ) );
        responseUserEntity.setCorrect( responseUser.isCorrect() );

        return responseUserEntity;
    }

    protected List<ResponseUserEntity> responseUserListToResponseUserEntityList(List<ResponseUser> list) {
        if ( list == null ) {
            return null;
        }

        List<ResponseUserEntity> list1 = new ArrayList<ResponseUserEntity>( list.size() );
        for ( ResponseUser responseUser : list ) {
            list1.add( responseUserToResponseUserEntity( responseUser ) );
        }

        return list1;
    }

    protected QuestionEntity questionToQuestionEntity(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionEntity questionEntity = new QuestionEntity();

        questionEntity.setId( question.getId() );
        questionEntity.setText( question.getText() );
        questionEntity.setCorrectAnswer( question.getCorrectAnswer() );
        questionEntity.setTopic( question.getTopic() );
        questionEntity.setResponses( responseListToResponseEntityList( question.getResponses() ) );
        questionEntity.setListResponses( responseUserListToResponseUserEntityList( question.getListResponses() ) );

        return questionEntity;
    }

    protected List<Response> responseEntityListToResponseList(List<ResponseEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Response> list1 = new ArrayList<Response>( list.size() );
        for ( ResponseEntity responseEntity : list ) {
            list1.add( fromEntity( responseEntity ) );
        }

        return list1;
    }

    protected Candidate candidateEntityToCandidate(CandidateEntity candidateEntity) {
        if ( candidateEntity == null ) {
            return null;
        }

        Candidate candidate = new Candidate();

        candidate.setId( candidateEntity.getId() );
        if ( candidateEntity.getUuid() != null ) {
            candidate.setUuid( candidateEntity.getUuid().toString() );
        }
        candidate.setFirstname( candidateEntity.getFirstname() );
        candidate.setLastname( candidateEntity.getLastname() );
        candidate.setEmail( candidateEntity.getEmail() );

        return candidate;
    }

    protected ResponseUser responseUserEntityToResponseUser(ResponseUserEntity responseUserEntity) {
        if ( responseUserEntity == null ) {
            return null;
        }

        ResponseUser responseUser = new ResponseUser();

        responseUser.setId( responseUserEntity.getId() );
        responseUser.setCandidate( candidateEntityToCandidate( responseUserEntity.getCandidate() ) );
        responseUser.setQuestion( questionEntityToQuestion( responseUserEntity.getQuestion() ) );
        responseUser.setResponse( fromEntity( responseUserEntity.getResponse() ) );
        responseUser.setCorrect( responseUserEntity.isCorrect() );

        return responseUser;
    }

    protected List<ResponseUser> responseUserEntityListToResponseUserList(List<ResponseUserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ResponseUser> list1 = new ArrayList<ResponseUser>( list.size() );
        for ( ResponseUserEntity responseUserEntity : list ) {
            list1.add( responseUserEntityToResponseUser( responseUserEntity ) );
        }

        return list1;
    }

    protected Question questionEntityToQuestion(QuestionEntity questionEntity) {
        if ( questionEntity == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( questionEntity.getId() );
        question.setText( questionEntity.getText() );
        question.setCorrectAnswer( questionEntity.getCorrectAnswer() );
        question.setTopic( questionEntity.getTopic() );
        question.setResponses( responseEntityListToResponseList( questionEntity.getResponses() ) );
        question.setListResponses( responseUserEntityListToResponseUserList( questionEntity.getListResponses() ) );

        return question;
    }
}
