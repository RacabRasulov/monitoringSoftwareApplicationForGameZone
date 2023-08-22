package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.devices.CreatDevicesRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.devices.GetDevicesByIdResponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.devices.UpdateDevicesResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.devices.GetAllDevicesRequest;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;

import java.util.List;
import java.util.UUID;

public interface DeviceService {

    void add(CreatDevicesRequest creatDeviceRequest) throws BusinessException;

    List<GetAllDevicesRequest> getAll();

    void delete(UUID id);

    void update(UpdateDevicesResponse updateDevicesResponse);


    GetDevicesByIdResponse getById(UUID id);
}
