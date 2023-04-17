package it.smartdpi.dpiservice.service;

import it.smartdpi.dpiservice.dto.DpiDto;
import it.smartdpi.dpiservice.entity.Dpi;
import it.smartdpi.dpiservice.repository.DpiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DpiService {

    @Autowired
    private DpiRepository dpiRepository;

    public List<DpiDto> getDpisByTenantId(Long idTenant) {
        List<Dpi> dpis = this.dpiRepository.getDpiByTenantId(idTenant);
        List<DpiDto> dpisDto = new ArrayList<>();
        for(Dpi dpi : dpis) {
            DpiDto dpiDto = new DpiDto(
                    dpi.getId(),
                    dpi.getCodice(),
                    dpi.getMarca(),
                    dpi.getModello(),
                    dpi.getDataScadenza(),
                    dpi.getNote());
            dpisDto.add(dpiDto);
        }
        return dpisDto;
    }


}
