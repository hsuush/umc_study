package umc5th.spring.converter;

import umc5th.spring.domain.Region;
import umc5th.spring.domain.Store;
import umc5th.spring.web.dto.StoreRequestDTO;
import umc5th.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.CreateStoreResultDto toStoreResultDTO(Store store){
        return StoreResponseDTO.CreateStoreResultDto.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.CreateDto request, Region region){
        return Store.builder()
                .name(request.getName())
                .type(request.getType())
                .address(request.getAddress())
                .region(region)
                .build();

    }
}
