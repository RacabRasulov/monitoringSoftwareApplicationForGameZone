package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.service.DeviceManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.device.CreatDeviceRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.device.GetDeviceByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.device.UpdateDeviceRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.devices.GetAllDeviceResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.exception.BusinessException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/device")
@AllArgsConstructor
public class DeviceController {
    private final DeviceManager deviceManager;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void add(@RequestBody @Valid CreatDeviceRequest creatDeviceRequest) throws BusinessException {
        deviceManager.add(creatDeviceRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllDeviceResponse> getAll() {
        return deviceManager.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
        deviceManager.delete(id);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateDeviceRequest updateDeviceRequest) {
        deviceManager.update(updateDeviceRequest);
    }

    @GetMapping("/getById")
    public ResponseEntity<GetDeviceByIdRequest> getById(String id) {

        return ResponseEntity.ok(deviceManager.getById(UUID.fromString(id)));
    }
}
