package az.monitoringSoftware.monitoringSoftware.business.rules;

import az.monitoringSoftware.monitoringSoftware.core.utilities.exception.BusinessException;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.DeskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeskBusinessRules {
    public final DeskRepository deskRepository;
    public void checkIfDeskExists(String name) throws BusinessException {
        if (deskRepository.existsByName(name))
            throw new BusinessException("Desk already exists");

    }
}
