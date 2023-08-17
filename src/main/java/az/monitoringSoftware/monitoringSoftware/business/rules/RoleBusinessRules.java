package az.monitoringSoftware.monitoringSoftware.business.rules;

import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleBusinessRules {

private RoleRepository roleRepository;
    public void checkIfRoleExists(String name) throws BusinessException {
        if(roleRepository.existsByName(name))
            throw new BusinessException("Role already exists");
    }


}
