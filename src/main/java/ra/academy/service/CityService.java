package ra.academy.service;

import lombok.RequiredArgsConstructor;
import ra.academy.repository.ICityRepository;

@RequiredArgsConstructor
public class CityService implements ICityService{
    private final ICityRepository iCityRepository;
}
