package br.com.ByteNest.PropertEase.services;

import br.com.ByteNest.PropertEase.models.realty.Realty;
import br.com.ByteNest.PropertEase.models.realty.RealtyRepository;
import br.com.ByteNest.PropertEase.models.realty.RegisterRealtyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Service
public class RealtyServices {

    @Autowired
    private RealtyRepository repository;


    public ResponseEntity<String> register(RegisterRealtyData data) {
        Realty realty = new Realty(data);

        repository.save(realty);

        return new ResponseEntity<>("Realty created", HttpStatus.CREATED);
    }

    public ResponseEntity<Page<Realty>> getAll(@RequestParam(defaultValue = "0") int page) {

        int definedSize = 5;

        Pageable p = PageRequest.of(page, definedSize);
        Page<Realty> realty = repository.findAll(p);

        return new ResponseEntity<>(realty,HttpStatus.OK);
    }

    public ResponseEntity<Optional<Realty>> getRealtyById(@PathVariable UUID id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<String> updateFullRealty(@PathVariable UUID id, @RequestBody RegisterRealtyData data) {
        Optional<Realty> optionalRealty = repository.findById(id);

        if(optionalRealty.isPresent()) {
            Realty realty = optionalRealty.get();
            realty.updateRealtyInfo(data);

            repository.save(realty);
            return new ResponseEntity<>("Realty updated \n", HttpStatus.OK);
        }

        return new ResponseEntity<>("This realty does not exist", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateRealtyStatus(@PathVariable UUID id, @RequestBody RegisterRealtyData data) {
        Optional<Realty> optionalRealty = repository.findById(id);

        if(optionalRealty.isPresent()) {
            Realty realty = optionalRealty.get();
            realty.updateRealtyStatus(data);

            repository.save(realty);
            return new ResponseEntity<>("Realty status updated", HttpStatus.OK);
        }

        return new ResponseEntity<>("This realty does not exist", HttpStatus.BAD_REQUEST);
    }
}
