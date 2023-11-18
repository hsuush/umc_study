package umc5th.spring.service.MissionService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.converter.MissionConverter;
import umc5th.spring.domain.Mission;
import umc5th.spring.domain.Store;
import umc5th.spring.repository.MissionRepository;
import umc5th.spring.repository.StoreRepository;
import umc5th.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{
    final private MissionRepository missionRepository;
    final private StoreRepository storeRepository;
    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.CreateDto request, Long storeId) {
        Store store = storeRepository.getReferenceById(storeId);
        Mission newMission = MissionConverter.toMission(request, store);

        return missionRepository.save(newMission);
    }
}
