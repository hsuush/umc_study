package umc5th.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.converter.StoreConverter;
import umc5th.spring.domain.Region;
import umc5th.spring.domain.Store;
import umc5th.spring.repository.RegionRepository;
import umc5th.spring.repository.StoreRepository;
import umc5th.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    final private StoreRepository storeRepository;
    final private RegionRepository regionRepository;

    @Override
    @Transactional
    public Store createStore(StoreRequestDTO.CreateDto request, Long regionId) {
        Region region = regionRepository.getReferenceById(regionId);
        Store newStore = StoreConverter.toStore(request, region);

        return storeRepository.save(newStore);
    }
}
