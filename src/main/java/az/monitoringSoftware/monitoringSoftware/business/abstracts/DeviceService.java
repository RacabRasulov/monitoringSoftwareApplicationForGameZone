package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.device.CreatDeviceRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.device.GetDeviceByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.device.UpdateDeviceRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.devices.GetAllDeviceResponse;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;

import java.util.List;
import java.util.UUID;

public interface DeviceService {

    void add(CreatDeviceRequest creatDeviceRequest) throws BusinessException;

    List<GetAllDeviceResponse> getAll();

    void delete(UUID id);

    void update(UpdateDeviceRequest updateDeviceRequest);


    GetDeviceByIdRequest getById(UUID id);
}
