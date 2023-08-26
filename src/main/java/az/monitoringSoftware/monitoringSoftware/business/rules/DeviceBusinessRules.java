package az.monitoringSoftware.monitoringSoftware.business.rules;

import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviceBusinessRules {

    private final DeviceRepository deviceRepository;

    public void checkIfDeviceExists(String name) throws BusinessException {

        if (deviceRepository.existsByName(name))
            throw new BusinessException("Device already exists");
    }
}
