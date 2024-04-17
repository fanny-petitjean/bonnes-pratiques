package org.mines.address.web.controller;

import org.mines.address.api.controller.BirthdateApi;
import org.mines.address.api.model.Birthdate;
import org.mines.address.api.model.Town;
import org.mines.civilstate.domain.model.BirthDate;
import org.mines.civilstate.port.driving.BirthDateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class BirthDateController implements BirthdateApi {
    private BirthDateUseCase birthDateUseCase;

    @Autowired
    public BirthDateController(BirthDateUseCase birthDateUseCase) {
        this.birthDateUseCase = birthDateUseCase;
    }

    @Override
    public ResponseEntity<Birthdate> getBirthdate(String id) {
        UUID uuid = UUID.fromString(id);

        return birthDateUseCase.get(uuid)
                .map(this::map)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return BirthdateApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<Birthdate>> listBirthdates() {
        return ResponseEntity.ok(birthDateUseCase.list().stream().map(this::map).collect(Collectors.toList()));
    }




    private BirthDate map(Birthdate birthdate) {
        return new BirthDate.BirthDateBuilder()
                .withId(birthdate.getId() == null ? null : UUID.fromString(birthdate.getId()))
                .withDay(birthdate.getDay())
                .withMonth(birthdate.getMonth())
                .withYear(birthdate.getYear())
                .build();
    }

    private Birthdate map(org.mines.civilstate.domain.model.BirthDate birthdate) {
        Birthdate apiBirthdate = new Birthdate();
        apiBirthdate.setId(apiBirthdate.getId());
        apiBirthdate.setDay(birthdate.day());
        apiBirthdate.setMonth(birthdate.month());
        apiBirthdate.setYear(birthdate.year());

        return apiBirthdate;
    }



}
