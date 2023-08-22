package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.concretes.DeviceManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.devices.CreatDevicesRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.devices.GetDevicesByIdResponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.devices.UpdateDevicesResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.devices.GetAllDevicesRequest;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/device")
@AllArgsConstructor
public class DeviceController {
    private final DeviceManager deviceManager;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void add(@RequestBody @Valid CreatDevicesRequest creatDeviceRequest) throws BusinessException {
        deviceManager.add(creatDeviceRequest);
    }


    @GetMapping("/getAll")
    public List<GetAllDevicesRequest> getAll() {
        return deviceManager.getAll();
    }

    @DeleteMapping("/delete{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id){
        deviceManager.delete(id);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateDevicesResponse updateDevicesResponse){
        deviceManager.update(updateDevicesResponse);
    }

    @GetMapping("/getById")
    public GetDevicesByIdResponse getById(UUID id){

       return deviceManager.getById(id);

    }


}
