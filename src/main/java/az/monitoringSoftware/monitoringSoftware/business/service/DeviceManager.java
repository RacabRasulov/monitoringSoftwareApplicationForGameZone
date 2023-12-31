package az.monitoringSoftware.monitoringSoftware.business.service;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.DeviceService;
import az.monitoringSoftware.monitoringSoftware.business.requests.device.CreatDeviceRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.device.GetDeviceByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.device.UpdateDeviceRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.devices.GetAllDeviceResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.exception.BusinessException;
import az.monitoringSoftware.monitoringSoftware.business.rules.DeviceBusinessRules;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.DeviceRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Device;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@Slf4j
@AllArgsConstructor
public class DeviceManager implements DeviceService {
    private final ModelMapperManager modelMapperManager;
    private final DeviceBusinessRules deviceBusinessRules;
    private final DeviceRepository deviceRepository;

    @Override
    public void add(CreatDeviceRequest creatDeviceRequest) throws BusinessException {
        log.info("A new device has been created" + creatDeviceRequest);
        deviceBusinessRules.checkIfDeviceExists(creatDeviceRequest.getName());
        Device device = modelMapperManager.forRequest().
                map(creatDeviceRequest, Device.class);
        log.info("A new device has been added to memory");
        deviceRepository.save(device);

    }

    @Override
    public List<GetAllDeviceResponse> getAll() {
        List<Device> devices = deviceRepository.findAll();
        List<GetAllDeviceResponse> devicesList = devices
                .stream()
                .map(device -> modelMapperManager.forRequest()
                        .map(device, GetAllDeviceResponse.class))
                .toList();
        return devicesList;

    }

    @Override
    public void delete(UUID id) {
        log.info("Deleted from database based on requested id" + id);
        deviceRepository.deleteById(id);
    }

    @Override
    public void update(UpdateDeviceRequest updateDeviceRequest) {
        log.info("Data found based on id" + updateDeviceRequest);
        Optional<Device> devices = deviceRepository.findById(UUID
                .fromString(String.valueOf(updateDeviceRequest.getId())));
        log.info("The information found has been imported" + devices);
        Device device = devices.get();
        log.info("Changed accordingly" + updateDeviceRequest);
        modelMapperManager.forRequest().map(updateDeviceRequest, device);
        log.info("New data was written to the database" + device);
        deviceRepository.save(device);
    }


    @Override
    public GetDeviceByIdRequest getById(UUID id) {
        log.info("Data found based on the entered id" + id);
        return modelMapperManager.forResponse()
                .map(deviceRepository.findById(
                                UUID.fromString(String.valueOf((id))))
                        , GetDeviceByIdRequest.class);

    }


}
