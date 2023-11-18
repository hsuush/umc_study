package umc5th.spring.service.StoreService;

import org.springframework.stereotype.Service;
import umc5th.spring.domain.Store;
import umc5th.spring.web.dto.StoreRequestDTO;


public interface StoreCommandService {
    Store createStore(StoreRequestDTO.CreateDto request, Long regionId);
}
