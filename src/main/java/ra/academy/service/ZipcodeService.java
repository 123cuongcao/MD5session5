package ra.academy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.academy.entity.Zipcode;
import ra.academy.repository.IZipcodeRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ZipcodeService implements IZipcodeService {
    private final IZipcodeRepository iZipcodeRepository;
    @Override
    public Zipcode findZipcodeById(Long id) throws NoSuchElementException {
        return iZipcodeRepository.findById(id).orElseThrow();
    }
}
