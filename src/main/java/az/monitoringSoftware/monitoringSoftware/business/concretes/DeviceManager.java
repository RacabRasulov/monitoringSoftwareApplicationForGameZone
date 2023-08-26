package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.DeviceService;
import az.monitoringSoftware.monitoringSoftware.business.requests.devices.CreatDevicesRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.devices.GetDevicesByIdResponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.devices.UpdateDevicesResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.devices.GetAllDevicesRequest;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;
import az.monitoringSoftware.monitoringSoftware.business.rules.DeviceBusinessRules;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.DeviceRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Device;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class DeviceManager implements DeviceService {
    private final ModelMapperManager modelMapperManager;
    private final DeviceBusinessRules deviceBusinessRules;
    private final DeviceRepository deviceRepository;

    @Override
    public void add(CreatDevicesRequest creatDeviceRequest) throws BusinessException {
        deviceBusinessRules.checkIfDeviceExists(creatDeviceRequest.getName());
        Device device = modelMapperManager.forRequest().
                map(creatDeviceRequest, Device.class);
        deviceRepository.save(device);

    }

    @Override
    public List<GetAllDevicesRequest> getAll() {
        List<Device> devices = deviceRepository.findAll();
        List<GetAllDevicesRequest> devicesList = devices
                .stream()
                .map(device -> modelMapperManager.forRequest()
                        .map(device, GetAllDevicesRequest.class))
                .toList();
        return devicesList;

    }

    @Override
    public void delete(UUID id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public void update(UpdateDevicesResponse updateDevicesResponse) {

        Optional<Device> devices = deviceRepository.findById(UUID.fromString(String.valueOf(updateDevicesResponse.getId())));

//        if (devices == null) {
//          throw new NotFoundException(
//                    getMessage("devices.doesntExists", null, null, null
//                    ));
        Device device = devices.get();

        modelMapperManager.forRequest().map(updateDevicesResponse, device);
        deviceRepository.save(device);
    }


    @Override
    public GetDevicesByIdResponse getById(UUID id) {
        return modelMapperManager.forResponse()
                .map(deviceRepository.findById(
                                UUID.fromString(String.valueOf((id))))
                        , GetDevicesByIdResponse.class);

    }


}
