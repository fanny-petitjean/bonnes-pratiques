package org.mines.civilstate.domain.service;

import org.mines.civilstate.domain.model.BirthDate;
import org.mines.civilstate.port.driven.BirthDateRepositoryPort;
import org.mines.civilstate.port.driving.BirthDateUseCase;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BirthDateService implements BirthDateUseCase {

    private BirthDateRepositoryPort birthDateRepositoryPort;

    public BirthDateService(BirthDateRepositoryPort birthDateRepositoryPort) {
        this.birthDateRepositoryPort = birthDateRepositoryPort;
    }

    @Override
    public BirthDate save(BirthDate birthDate) {
        if (birthDate.day() < 0){
            throw new IllegalArgumentException("Day must be greater than 0");
        } else if (birthDate.month() < 0){
            throw new IllegalArgumentException("Month must be greater than 0");
        } else if (birthDate.year() < 0){
            throw new IllegalArgumentException("Year must be greater than 0");
        }
        if(birthDate.day() > 31){
            throw new IllegalArgumentException("Day must be less than 31");
        } else if (birthDate.month() > 12){
            throw new IllegalArgumentException("Month must be less than 12");
        } else if (birthDate.year() > 2024){
            throw new IllegalArgumentException("Year must be less than 2024");
        }

        BirthDate b = birthDateRepositoryPort.insert(birthDate);
        return b;
    }

    @Override
    public Collection<BirthDate> list() {
        return birthDateRepositoryPort.selectAll();
    }

    @Override
    public Optional<BirthDate> get(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Collection<BirthDate> findPeriodOfBirth(int beginDay, int endDay, int beginMonth, int endMonth, int beginYear, int endYear) {
        return List.of();
    }

    @Override
    public Collection<BirthDate> findStartPeriodOfBirth(int beginDay, int beginMonth, int beginYear) {
        return List.of();
    }

    @Override
    public Collection<BirthDate> findEndPeriodOfBirth(int endDay, int endMonth, int endYear) {
        Collection<BirthDate> birthDates = birthDateRepositoryPort.selectAll();
        List<BirthDate> birthDatesBeforeEndPeriod = new ArrayList<>();

        for (BirthDate birthDate : birthDates) {
            if (birthDate.year() < endYear ||
                    (birthDate.year() == endYear && birthDate.month() < endMonth) ||
                    (birthDate.year() == endYear && birthDate.month() == endMonth && birthDate.day() <= endDay)) {
                birthDatesBeforeEndPeriod.add(birthDate);
            }
        }

        return birthDatesBeforeEndPeriod;
    }

    @Override
    public void remove(UUID uuid) {
        if(birthDateRepositoryPort.select(uuid).isEmpty()){
            throw new IllegalArgumentException("BirthDate not found");
        }
        birthDateRepositoryPort.delete(uuid);
    }
}
