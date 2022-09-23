package com.alwa.annualleavewebapp.services;

import com.alwa.annualleavewebapp.entities.User;
import com.alwa.annualleavewebapp.entities.Application;
import com.alwa.annualleavewebapp.exceptions.NoApplicationFoundException;
import com.alwa.annualleavewebapp.repository.ApplicationRepository;
import com.alwa.annualleavewebapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    ApplicationRepository applicationRepository;
    UserRepository userRepository;

    public ApplicationService (ApplicationRepository applicationRepository, UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
    }

    public Application createApplication (Application application) throws NoApplicationFoundException {

        Optional<User> findIfUserExists = userRepository.findById(application.getUser().getId());

        if(!findIfUserExists.isPresent()) {
            throw new NoApplicationFoundException("User doesn't exists.");
        }

        application.setUser(findIfUserExists.get());
        application.setDays_off(application.getDays_off());

        return applicationRepository.save(application);

    }

    public Application editApplication(Application application) throws NoApplicationFoundException {

        Optional<Application> findIfApplicationExists = applicationRepository.findById(application.getId());
        findIfApplicationExists.get().setDays_off(application.getDays_off());

        if (!findIfApplicationExists.isPresent()) {
            throw new NoApplicationFoundException("Application doesn't exists.");
        }

        return applicationRepository.save(findIfApplicationExists.get());
    }

    public void deleteApplication(long id) throws NoApplicationFoundException {

        Optional<Application> findIfApplicationExists = applicationRepository.findById(id);

        if(!findIfApplicationExists.isPresent()) {
            throw new NoApplicationFoundException("Application doesn't exists.");
        }

        applicationRepository.deleteById(id);

    }

}
